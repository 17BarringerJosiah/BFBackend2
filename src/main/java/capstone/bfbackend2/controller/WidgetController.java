package capstone.bfbackend2.controller;

import capstone.bfbackend2.Widget;
import capstone.bfbackend2.service.WidgetService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/widget")
@CrossOrigin(origins = "http://localhost:5173")
public class WidgetController {

    private final WidgetService widgetService;

    public WidgetController(WidgetService widgetService) {
        this.widgetService = widgetService;
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Widget createWidget(
            @RequestPart("widget") Widget widget,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile
    ) {
        if (imageFile != null && !imageFile.isEmpty()) {
            try {

                String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
                Path uploadPath = Paths.get("uploads/");
                Files.createDirectories(uploadPath);

                Path filePath = uploadPath.resolve(fileName);
                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                widget.setImage_url("/uploads/" + fileName);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save image file", e);
            }
        }

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
