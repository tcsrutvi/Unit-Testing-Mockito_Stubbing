package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	@Mock
	ItemRepository repository;
	
	@InjectMocks
	ItemBusinessService businessService;
	
	@Test
	void testsaveItem() {
		Item item = new Item(2, "Item2", 20, 20);
		businessService.saveItem(item);
	}

	@Test
	void testretreiveHardcodedItem() {
		ItemBusinessService businessService = new ItemBusinessService();
		Item item = businessService.retreiveHardcodedItem();
		assertNotNull(item);
		assertEquals(new Item(1, "Ball", 10, 100), item);
	}

	@Test
	void testretrieveAllItems() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 20, 20)));
		businessService.retrieveAllItems();
	}
	
	void testRetriveAllItemsWithZeroItem() {
		when(repository.findAll()).thenReturn(Arrays.asList());
		businessService.retrieveAllItems();
		
	}
	
	
}
