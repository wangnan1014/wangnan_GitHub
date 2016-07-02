package com.heag.rcpc.dao;

import java.util.ArrayList;

import com.heag.rcpc.model.RpIndustry;
import com.heag.rcpc.model.RpIndustryExample;

public interface IRpIndustryDao {

	public ArrayList<RpIndustry> selectByExample(RpIndustryExample rie);

}
