package com.symbio.vmware.utils;


import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.paypal.selion.platform.dataprovider.impl.FileSystemResource;
import com.symbio.vmware.dataobjects.Myobject;

public final class MultiDataProvider {
  
    public static Object[][] multiDataProvider(Class<?> classObject, String yamlfile) {
    	    Constructor constructor = new Constructor(classObject);
    	    FileSystemResource resource = new FileSystemResource(String.format("src/test/resources/testdata/%s.yaml", yamlfile));

    		Yaml yaml = new Yaml(constructor);
    		Iterable<Object> data = yaml.loadAll(resource.getInputStream());
    		
    		@SuppressWarnings("unchecked")
    		List<Object> list = IteratorUtils.toList(data.iterator());
    				
    		Object[][] returnData = new Object[list.size()][1];
    		
    		for (int i = 0; i < list.size(); i++) {
    			Object obj = list.get(i); 
    			 
    			returnData[i][0] = obj;
    		}
    	    return returnData;
    	  
    	}
    }
