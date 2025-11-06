package capstone.bfbackend2.service;


import capstone.bfbackend2.Color;
import capstone.bfbackend2.Widget;
import capstone.bfbackend2.WidgetVariant;
import capstone.bfbackend2.repository.ColorRepository;
import capstone.bfbackend2.repository.WidgetRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    private final WidgetRepository widgetRepository;
    private final ColorRepository colorRepository;

    public WidgetService(WidgetRepository widgetRepository, ColorRepository colorRepository) {
        this.widgetRepository = widgetRepository;
        this.colorRepository = colorRepository;
    }

    private ArrayList<Widget> widgetList = new ArrayList<>();

    @Transactional
    public Widget saveWidget(Widget widget) {
        if (widget.getVariants() != null) {
            for (WidgetVariant variant : widget.getVariants()) {
                Color color = variant.getColor();

                if (color != null) {

                    if (color.getColor_id() != null) {
                        color = colorRepository.findById(color.getColor_id())
                                .orElseThrow(() -> new IllegalArgumentException("Invalid color ID"));
                    }

                    else if (color.getColorLabel() != null) {
                        Optional<Color> existingColor = colorRepository.findByColorLabelAndColorHex(color.getColorLabel(), color.getColorHex());
                        if (existingColor.isPresent()) {
                            color = existingColor.get();
                        } else {

                            color = colorRepository.save(color);
                        }
                    }

                    else {
                        Color defaultColor = colorRepository.findByColorLabelAndColorHex("Default", "000000")
                                .orElseGet(() -> {
                                    Color def = new Color();
                                    def.setColorCode("DEFAULT");
                                    def.setColorLabel("Default");
                                    def.setColorHex("#CCCCCC");
                                    return colorRepository.save(def);
                                });
                        color = defaultColor;
                    }

                    variant.setColor(color);
                } else {

                    Color defaultColor = colorRepository.findByColorLabelAndColorHex("Default", "000000")
                            .orElseGet(() -> {
                                Color def = new Color();
                                def.setColorCode("DEFAULT");
                                def.setColorLabel("Default");
                                def.setColorHex("#CCCCCC");
                                return colorRepository.save(def);
                            });
                    variant.setColor(defaultColor);
                }


                variant.setWidget(widget);
            }
        }

        return widgetRepository.save(widget);
    }




    public List<Widget> findAllWidgets() {
        return widgetRepository.findAll();
    }

    public Widget findWidgetById(Long id) {
        return widgetRepository.findById(id).get();
    }

    public Widget updateWidgetById(Long id, Widget widget) {

        return widgetRepository.save(widget);
    }

    public Widget partialUpdateWidget(Long id, Widget widget) {
        Widget existingWidget = widgetRepository.findById(id).orElse(null);
        if (existingWidget == null) {
            System.out.println("Widget not found with id " + id);
        }
        if (widget.getWidget_name() != null) {
            existingWidget.setWidget_name(widget.getWidget_name());
        }


        return widgetRepository.save(existingWidget);
    }

    public void deleteWidget(Long id){
        if(!widgetRepository.existsById(id)){
            System.out.println("Widget not found with id " + id);
        }
        // Send back Delete status success
        widgetRepository.deleteById(id);
    }



}
