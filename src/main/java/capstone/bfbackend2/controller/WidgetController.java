package capstone.bfbackend2.controller;

import capstone.bfbackend2.Widget;
import capstone.bfbackend2.service.WidgetService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/widget")
@CrossOrigin(origins = "http://localhost:5173")
public class WidgetController {

    private final WidgetService widgetService;

    public WidgetController(WidgetService widgetService) {
        this.widgetService = widgetService;
    }


    @PostMapping
    public Widget createWidget(@RequestBody Widget widget){
        return widgetService.saveWidget(widget);
    }

    @GetMapping
    public List<Widget> getWidget(){
        return widgetService.findAllWidgets()
                .stream()
                .toList();

    }

    @GetMapping("/{id}")
    public Widget getWidgetById(@PathVariable Long id){
        return widgetService.findWidgetById(id);
    }

    @PutMapping("/{id}")
    public Widget updateWidgetById(@PathVariable Long id, @RequestBody Widget widget) {
        return (Widget) widgetService.updateWidgetById(id, widget);
    }

    @PatchMapping("/{id}")
    public Widget partialUpdateWidget(@PathVariable Long id, @RequestBody Widget widget){
        return (Widget) widgetService.partialUpdateWidget(id, widget);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWidget(@PathVariable Long id){
        widgetService.deleteWidget(id);
        return ResponseEntity.noContent().build();
    }

}
