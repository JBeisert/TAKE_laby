package lab.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaint")
@NamedQuery(name = "Complaint.findByStatus", query =
        "SELECT c FROM Complaint c WHERE c.status = :status"
)
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private LocalDate complaintDate;
    @NotNull
    @Size(min = 1, max = 60)
    private String complaintText;
    @NotNull
    @Size(min = 1, max = 60)
    private String author;
    @NotNull
    @Size(min = 1, max = 6)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", complaintDate=" + complaintDate +
                ", complaintText='" + complaintText + '\'' +
                ", author='" + author + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}