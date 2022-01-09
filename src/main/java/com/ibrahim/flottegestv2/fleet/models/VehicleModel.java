package com.ibrahim.flottegestv2.fleet.models;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

import com.ibrahim.flottegestv2.parameters.models.CommonObject;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class VehicleModel extends CommonObject {

}
