package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {

	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
	// 위에 코드와 같다
	/*
	@Autowired
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	*/
	
}
