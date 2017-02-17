package com.protry.validator;

import com.protry.entity.ProductDetail;
import com.protry.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by bshao on 2017/2/17.
 */
@Component
public class ProductDetailValidator implements Validator{

	private final InventoryService inventoryService;

	public ProductDetailValidator(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@Autowired


	@Override
	public boolean supports(Class<?> aClass) {
		return ProductDetail.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ProductDetail detail = (ProductDetail) o;
		if (!inventoryService.isValidInventory(detail.getInventoryId())) {
			errors.rejectValue("inventoryId", "inventory.id.invalid", "Inventory ID is Invalid");
		}
	}
}
