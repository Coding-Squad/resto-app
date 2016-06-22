package com.reminisense.ra.service;

import com.reminisense.ra.dto.json.TransactRequestDto;
import com.reminisense.ra.dto.json.VerifyRequestDto;
import com.reminisense.ra.dto.json.VerifyResultDto;
import com.reminisense.ra.exception.VerificationException;

/**
 * Created by Nigs on 2016-05-17.
 */
public interface VerificationService {

    VerifyResultDto verify(VerifyRequestDto dto) throws VerificationException;

    void transact(TransactRequestDto dto) throws VerificationException;
}
