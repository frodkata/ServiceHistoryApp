package serviceHistoryApplication.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="history", schema = "service_history")
public class History {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    @Column(name = "serviceName")
    @NotEmpty(message = "Service name can not be empty!!")
    private String serviceName;

    @Column(name = "partName")
    @NotEmpty(message = "Part name can not be empty!!")
    private String partName;

    @Column(name = "millage")
    @NotNull(message = "Millage can not be null!!")
    private Long millage;

    @Column(name = "price")
    private Double price;

    @Column(name="date")
    @NotNull(message = "Date  can not be null!!")
    @NotEmpty(message = "Date can not be empty!!")
    private String date;

    @Column(name="user_id")
    private Long userID;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Long getMillage() {
        return millage;
    }

    public void setMillage(Long millage) {
        this.millage = millage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
