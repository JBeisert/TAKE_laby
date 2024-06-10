package lab.app;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import lab.entities.Complaint;

import java.util.List;

public class Main {
    private static final String BASE_URL = "http://localhost:8080/Server-1.0-SNAPSHOT/api/complaints";

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        String status = getStatus(client, 251);
        System.out.println("Status: " + status);

        List<Complaint> complaints = getComplaints(client);
        System.out.println(complaints);

        Complaint complaint = getFirstOpenComplaint(client);
        System.out.println(complaint);

        closeComplaint(client, complaint);

        List<Complaint> openComplaints = getOpenComplaints(client);
        System.out.println(openComplaints);

        client.close();
    }

    private static String getStatus(Client client, int id) {
        return client.target(BASE_URL)
                .path("{id}/status")
                .resolveTemplate("id", id)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
    }

    private static List<Complaint> getComplaints(Client client) {
        return client.target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>() {});
    }

    private static Complaint getFirstOpenComplaint(Client client) {
        return client.target(BASE_URL)
                .queryParam("status", "open")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>() {})
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No open complaints found"));
    }

    private static void closeComplaint(Client client, Complaint complaint) {
        complaint.setStatus("close");
        client.target(BASE_URL)
                .path("{id}")
                .resolveTemplate("id", complaint.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(complaint), Complaint.class);
    }

    private static List<Complaint> getOpenComplaints(Client client) {
        return client.target(BASE_URL)
                .queryParam("status", "open")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>() {});
    }
}
