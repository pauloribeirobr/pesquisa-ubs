package dev.informacoesubs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import dev.informacoesubs.repository.UbsBaseRepository;
import dev.informacoesubs.service.ListaUbsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ListaUbsControllerTest {

	@Autowired
    MockMvc mockMvc;
	
	@Autowired
	ListaUbsService listaUbsService;

	@Autowired
	UbsBaseRepository ubsBaseRepository;
	
    @Test
    void pesquisaUbsProxima() throws Exception {
    	
    	double latitude = -23.604936;
    	double longitude = -46.692999;
    	int page = 1;
    	int per_page = 1;
    	
        //List<ToDo> toDoList = new ArrayList<ToDo>();
        //toDoList.add(new ToDo(1L,"Eat thrice",true));
        //;;toDoList.add(new ToDo(2L,"Sleep Twice",true));
        //when(toDoService.findAll()).thenReturn(toDoList);

    	mockMvc.perform(MockMvcRequestBuilders
    			.get("/find_ubs")
    			.param("query", String.valueOf(latitude) + "," + String.valueOf(longitude))
    			.param("page", String.valueOf(page))
    			.param("per_page", String.valueOf(per_page)))
    			.andExpect(content().contentType("application/json"));

//        mockMvc.perform(MockMvcRequestBuilders.get("/find_ubs")
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }
}
