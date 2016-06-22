package com.reminisense.ra.controllers.rest;

import com.reminisense.ra.dto.json.AssetDto;
import com.reminisense.ra.dto.json.RestResultDto;
import com.reminisense.ra.entity.CompanyEntity;
import com.reminisense.ra.service.AssetService;
import com.reminisense.ra.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Nigs on 2016-04-15.
 */
@RestController
@RequestMapping(value = "/api")
public class MainRestController {

    private static final Logger logger = LoggerFactory
            .getLogger(MainRestController.class);
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AssetService assetService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<AssetDto> list() {
        return assetService.listAssets();
    }

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public RestResultDto registerCompany(@Valid @RequestBody CompanyEntity company) {
        try {
            companyService.addCompany(company);
            return new RestResultDto(RestResultDto.RESULT_OK);
        } catch (Exception e) {
            return new RestResultDto(RestResultDto.RESULT_ERROR, e.getMessage());
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                if (!file.getContentType().startsWith("image")) {
                    return "not an image!!";
                }

                byte[] bytes = file.getBytes();
                // Creating the directory to store file
                // TODO ask pedro to provide directory with access
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                // Create the file on server
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }
}
