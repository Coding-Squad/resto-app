package com.reminisense.ra.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample Rest Controller
 * Created by Nigs on 2016-04-13.
 */
@RestController
// @ResponseBody
// @Controller
public class SampleRestController {

    /**
     * @param name
     * @return
     */
    // @PathVariable tells spring that the variable is obtained from our URL
    @RequestMapping(value = "/sample/{name}", method = RequestMethod.GET)
    public SampleJSON sample(@PathVariable String name) {
        // FIXME this is just a sample. all logic stuff are ideally done in the service/dao layers
        SampleJSON sampleJson = new SampleJSON();
        sampleJson.setName(name);
        sampleJson.setDescription("hey");
        sampleJson.setArr(new String[]{"foo", "bar", "baz"});
        return sampleJson;
    }

    class SampleJSON {
        private String name;
        private String description;
        private String[] arr;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String[] getArr() {
            return arr;
        }

        public void setArr(String[] arr) {
            this.arr = arr;
        }
    }
}
