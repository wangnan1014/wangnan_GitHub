package com.heag.rcpc.service;


import java.util.ArrayList;

import com.heag.rcpc.model.RpProvince;
import com.heag.rcpc.model.RpProvinceExample;

public interface IRpProvinceService {

	public ArrayList<RpProvince> selectByExample(RpProvinceExample rie); 

}
