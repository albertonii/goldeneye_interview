package com.codebay.goldeneye.services;

import com.codebay.goldeneye.dtos.EmailFormDto;

public interface IWebService {
    String generateEmail(EmailFormDto emailFormDto);
}
