package capstone.bfbackend2;

import jakarta.persistence.*;

@Entity
@Table(name = "lifecycle_status")
public class LifecycleStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lifecycleStatus_id;

    @Column(name = "lifecycle_status", nullable = false)
    private String lifecycleStatus;

    public LifecycleStatus(Long lifecycleStatus_id, String lifecycleStatus) {
        this.lifecycleStatus_id = lifecycleStatus_id;
        this.lifecycleStatus = lifecycleStatus;
    }

    public LifecycleStatus() {
        this.lifecycleStatus_id = 0L;
        this.lifecycleStatus = lifecycleStatus;
    }

    //Setters and Getters

    public Long getLifecycleStatus_id() {
        return lifecycleStatus_id;
    }

    public void setLifecycleStatus_id(Long lifecycleStatus_id) {
        this.lifecycleStatus_id = lifecycleStatus_id;
    }

    public String getLifecycleStatus() {
        return lifecycleStatus;
    }

    public void setLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
    }
}
