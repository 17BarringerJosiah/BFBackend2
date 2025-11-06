package capstone.bfbackend2;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long color_id;

    @Column(name = "color_code", nullable = false)
    private String colorCode;

    @Column(name = "color_label", nullable = false)
    private String colorLabel;

    @Column(name = "color_hex", nullable = false, length = 7)
    private String colorHex;

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
    private List<WidgetVariant> variants;

    public Color(Long color_id, String colorCode, String colorLabel, String colorHex) {
        this.color_id = color_id;
        this.colorCode = colorCode;
        this.colorLabel = colorLabel;
        this.colorHex = colorHex;
    }

    public Color() {
    }

    //Setter and Getter
    public Long getColor_id() {
        return color_id;
    }

    public void setColor_id(Long color_id) {
        this.color_id = color_id;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorLabel() {
        return colorLabel;
    }

    public void setColorLabel(String colorLabel) {
        this.colorLabel = colorLabel;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }
}
