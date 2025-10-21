package capstone.bfbackend2;

import capstone.bfbackend2.repository.WidgetRepository;
import capstone.bfbackend2.service.WidgetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import capstone.bfbackend2.Color;

@ExtendWith(MockitoExtension.class)
public class WidgetServiceTest {
    @Mock
    WidgetRepository widgetRepository;


        @InjectMocks
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

        @Test
        void shouldSaveWidget () {
            //Arrange
            when(widgetRepository.save(wrench)).thenReturn(wrench);
            //Act
            Widget actualWidget = widgetService.saveWidget(wrench);
            //Assert
            verify(widgetRepository, times(1)).save(any(Widget.class));
            assertThat(actualWidget).isEqualTo(wrench);
        }

        @Test
        void shouldFindAllWidgets () {
            //Arrange
            when(widgetRepository.findAll()).thenReturn(widgets);
            //Act
            List<Widget> listAllWidgets = widgetService.findAllWidgets();
            //Assert
            verify(widgetRepository, times(1)).findAll();
            assertThat(listAllWidgets).isEqualTo(widgets);
        }

        @Test
        void shouldFindWidgetById () {
            //Arrange
            when(widgetRepository.findById(1L)).thenReturn(Optional.of(wrench));

            //Act
            Widget foundSingleWidget = widgetService.findWidgetById(1L);

            //Assert
            verify(widgetRepository, times(1)).findById(1L);
            assertThat(foundSingleWidget).isEqualTo(wrench);
        }

    }
