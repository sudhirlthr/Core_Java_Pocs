package com.sudhir.map;

import java.util.*;

public class WayofIteration {

	public static void main(String[] args) {
		Map<String,Map<String,Integer>> result_Map = new HashMap<String, Map<String,Integer>>();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("Sudhir", 23);
		map.put("Kumar", 25);
		map.put("Awesome", 56);
		result_Map.put("abc", map);
		
		for(Map.Entry<String, Map<String, Integer>> obj : result_Map.entrySet()) {
			System.out.println("outer key = "+obj.getKey());
			Map<String, Integer> mapp = obj.getValue();
			Iterator itr = mapp.keySet().iterator();
			while(itr.hasNext()) {
				String ky = (String) itr.next();
				System.out.println("Inner key = "+ky+" and value = "+mapp.get(ky));
				
			}
		}
		
		ABC abc = new ABC();
		Address addressOfCustomer = new Address();
		addressOfCustomer.setName("TORONTO");
		Map<String, Integer> shoppingCart = new HashMap<>();
		shoppingCart.put("Apple", 11);
		Map<Warehouse, Map<String, Integer>> result = abc.getInventoryAllocation(shoppingCart, addressOfCustomer);
		
		for(Map.Entry<Warehouse, Map<String, Integer>> obj : result.entrySet()) {
			System.out.println("warehouse = "+obj.getKey());
			Map<String, Integer> mapp = obj.getValue();
			Iterator itr = mapp.keySet().iterator();
			while(itr.hasNext()) {
				String ky = (String) itr.next();
				System.out.println("product id = "+ky+" and quantity = "+mapp.get(ky));
				
			}
		}
	}

}

class ABC{
	
	public List<Warehouse> getNearestWarehouses(Address addressOfCustomer){
		List<Warehouse> list = new ArrayList<>();
		list.add(Warehouse.TORONTO);
		list.add(Warehouse.VANCOUVER);
		list.add(Warehouse.MONTREAL);
		list.add(Warehouse.EDMONTON);
		return list;
	}
	public Map<Warehouse, Integer> getInventory(String product){
		Map<Warehouse, Integer> map= new HashMap<>();
		if(product.equals("Apple")) {
			map.put(Warehouse.TORONTO, 3);
			map.put(Warehouse.MONTREAL, 3);
			map.put(Warehouse.VANCOUVER, 3);
			map.put(Warehouse.EDMONTON, 5);
		}
		else {
			map.put(Warehouse.TORONTO, 1);
			map.put(Warehouse.MONTREAL, 2);
			map.put(Warehouse.VANCOUVER, 3);
			map.put(Warehouse.EDMONTON, 4);
		}
		return map;
		
	}
	public Map<Warehouse, Map<String, Integer>>  getInventoryAllocation(Map<String, Integer> shoppingCart, Address addressOfCustomer) {

	    // 1. get All nearest warehouses
	    List<Warehouse> warehouseList = getNearestWarehouses(addressOfCustomer);
	    
	    // 2. Initialise the Map that will return final result 
	       Map<Warehouse,Map<String, Integer>> result_map = new LinkedHashMap<Warehouse, Map<String,Integer>>();
	       
	    // 3. Get ProductId and user quantity that he requested on shopping cart by iterating over above, map
	    for(Map.Entry<String, Integer> user_cart : shoppingCart.entrySet()){
	            String product_Id = user_cart.getKey();
	            Integer user_quantity_requested = user_cart.getValue();
	        
	        // 4. get the available product's quantity from warehouses
	        Map<Warehouse, Integer> warehouse_quantity = getInventory(product_Id);
	        
	        // 5. Iterate through shorter distance warehouses.
	        for(Warehouse warehouse: warehouseList){
	            // 6. map for storing the available quantity for products on warehouse wise
	            Map<String, Integer> innerMap = new HashMap<>();
	            
	            // 7. iterate through  each warehouse which have respective warehouse to get the quantity and to store
	            for(Map.Entry<Warehouse, Integer> wh_list:warehouse_quantity.entrySet()){
	                // For getting ware houses objects and their product quantity available in each location
	                Warehouse warehouse_obj = wh_list.getKey();
	                Integer available_quantity = wh_list.getValue();
	                
	                // 8. Compare if shorter distance warehouse and warehouse which contains product is same and it              does not include in outer(result_map) map
	                
	                if(warehouse_obj.equals(warehouse) && !result_map.containsKey(warehouse)){
	                    // 9. if current warehouse have more/equal quantity thtan requested by user
	                    if(user_quantity_requested <= available_quantity){
	                        innerMap.put(product_Id,user_quantity_requested);
	                        result_map.put(warehouse,innerMap);
	                    }
	                    else{
	                        user_quantity_requested = user_quantity_requested-available_quantity;
	                        innerMap.put(product_Id,available_quantity);
	                        result_map.put(warehouse,innerMap);
	                    }
	                    break;
	                }
	            }
	            
	        }
	        
	    }
	    return result_map;
	}
}
enum Warehouse {
    EDMONTON, MONTREAL, TORONTO, VANCOUVER
}


class Address{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}