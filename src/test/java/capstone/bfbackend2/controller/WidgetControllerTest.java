package capstone.bfbackend2.controller;

import capstone.bfbackend2.Color;
import capstone.bfbackend2.LifecycleStatus;
import capstone.bfbackend2.Widget;
import capstone.bfbackend2.WidgetMetrics;
import capstone.bfbackend2.service.WidgetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(WidgetController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureWebMvc
class WidgetControllerTest {

@Autowired
private MockMvc mockMvc;

@MockitoBean
    WidgetService widgetService;
    Widget wrench;
    List<Widget> widgets;

    @BeforeEach
    void setUp() {
        Color color = new Color(1L, "RED", "Red Label", "#FF0000");
        WidgetMetrics widgetMetrics = new WidgetMetrics(1L, 1, BigDecimal.valueOf(0.0));
        LifecycleStatus lifecycleStatus = new LifecycleStatus(1L, "Active");

        wrench = new Widget(
                1L,
                "Wrench",
                "Slug",
                "Blurb",
                "image_url",
                LocalDateTime.now(),
                LocalDateTime.now(),
                0,
                color,
                widgetMetrics,
                lifecycleStatus

        );

        widgets = new ArrayList<>(List.of(wrench));
    }

@Autowired
private ObjectMapper objectMapper;



//Create
    @Test
    void shouldCreateWidget() throws Exception {
        Mockito.when(widgetService.saveWidget(any(Widget.class))).thenReturn(wrench);
        String widgetJson = objectMapper.writeValueAsString(wrench);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/widget")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(widgetJson))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.widget_name").value("Wrench"));

        Mockito.verify(widgetService).saveWidget(any(Widget.class));
    }

//Read
    @Test
    void shouldGetAllWidgets() throws Exception{
        widgets.add(wrench);
        Mockito.when(widgetService.findAllWidgets()).thenReturn(widgets);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/widget"))
                .andExpect(status().isOk());

        Mockito.verify(widgetService).findAllWidgets();
    }

    @Test
    void shouldGetWidgetById() throws Exception{
        Mockito.when(widgetService.findWidgetById(1L)).thenReturn(wrench);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/widget/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

//Update
    //Put
    @Test
    void shouldUpdateWidgetById() throws Exception{
        //Arrange
        Widget updatedWidget = new Widget();
        updatedWidget.setId(1L);
        updatedWidget.setWidget_name("wrench");
        String updateContent = objectMapper.writeValueAsString(updatedWidget);

        //Act
        Mockito.when(widgetService.updateWidgetById(anyLong(), any(Widget.class)))
                .thenReturn(updatedWidget);

        //Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/api/widget/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.widget_name").value("wrench"));


    }

    //Patch
    @Test
    void shouldUpdateWidgetName() throws Exception{
        //Arrange
        Widget existingWidget = new Widget();
        existingWidget.setId(1L);
        existingWidget.setWidget_name("Wrench");

        //Act
        Mockito.when(widgetService.partialUpdateWidget(anyLong(), any(Widget.class)))
                .thenReturn(existingWidget);

        //Assert
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/widget/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"widget_name\":\"Wrench\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.widget_name").value("Wrench"));
    }

    @Test
    void shouldDeleteWidget() throws Exception{
        //Arrange & Act
        doNothing().when(widgetService).deleteWidget(anyLong());

        //Assert
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/widget/3"))
                .andExpect(status().isNoContent());
    }


}