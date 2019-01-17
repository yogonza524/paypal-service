/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author gonzalo
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AirlineLeg implements Serializable {
    private Integer number;
    private String classService;
    private String farebasisCode;
    private String stopOverPermited;
}
