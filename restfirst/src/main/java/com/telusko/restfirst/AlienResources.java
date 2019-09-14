package com.telusko.restfirst;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResources 
{
	
	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAliens()
	{
		System.out.println("from getAliens in alien resource");	
		return repo.getAliens();	
	}
	

	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id)
	{
		System.out.println("Single aalien***********");	
		return repo.getAlien(id);	
	}
	
	//localhost:8085/restfirst/webapi/aliens/alien/2
	
	@POST
	@Path("createalien")
	public Alien createAlien(Alien a1)
	{
		System.out.println("from postman input client side"+a1);
		repo.create(a1);		
		return a1;		
	}
	
	@PUT
	@Path("updatealien")
	public Alien updtateAlien(Alien a1)
	{
		System.out.println("from postman input client side update fun");
		Alien temp = repo.getAlien(a1.getId());
		System.out.println("temp alien data checking"+temp);
		System.out.println(temp.getId());
		int check = temp.getId();



		if(check != 0)
		{
			System.out.println("The data which yoy would like to update from postman input client side is there and update fun");		
			repo.update(a1);		
		}
		else {
			System.out.println("there is no data with this id name,so i am going to create data with this id name");		
			repo.create(a1);
		}
		

		return a1;		

	}
	
	@DELETE
	@Path("deletealien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien deleteAlien(@PathParam("id") int id)
	{
		System.out.println("Delete aalien fun from resources***********");
		
		Alien a = repo.getAlien(id);
		
		if(a.getId() != 0)
			repo.deleteAlien(id);
		
		return a;	
	}



}



/*
     <alien>
        <id>0</id>
        <name>Shema</name>
        <points>100</points>
    </alien>*/

/*package come.sureshe.demorest;


import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Path("aliens")
public class AlienResource 
{
	
	AlienRepositary repo = new AlienRepositary();
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAliens()
	{
		
		System.out.println("came inside get aliens fun which is inside alien resourc");
		
		
	
		

		return repo.getAliens();
		
	}

}
*/