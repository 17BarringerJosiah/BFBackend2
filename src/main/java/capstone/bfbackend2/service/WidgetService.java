package capstone.bfbackend2.service;


import capstone.bfbackend2.Widget;
import capstone.bfbackend2.repository.WidgetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {

    private final WidgetRepository widgetRepository;

    public WidgetService(WidgetRepository widgetRepository) {
        this.widgetRepository = widgetRepository;
    }

    private ArrayList<Widget> widgetList = new ArrayList<>();

    public Widget saveWidget(Widget widget) {
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
