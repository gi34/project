
package codingpart;


public class ClinicRecord1 {
    private int count = 0;
    private Node head;

    public void addData(Patients1 patients) {
        Node newNode = new Node(patients);

        if (head == null) {
            head = newNode;
        } else {
            newNode.setLink(head);
            head = newNode;
        }

        count++;
    }

    public boolean remove(String targetName) {
        if (head == null) {
            return false;
        }

        if (head.getInfo().getName().equals(targetName)) {
            head = head.getLink();
            return true;
        }

        Node previous = head;
        Node current = head.getLink();
        while (current != null) {
            if (current.getInfo().getName().equals(targetName)) {
                previous.setLink(current.getLink());
                return true;
            }
            previous = current;
            current = current.getLink();
        }

        return false;
    }

    public String search(String target) {
        Node current = head;
        String display="";
        while (current != null) {
            Patients1 patient = current.getInfo();
            if (patient.getName().equals(target)) {
                display=("Name: "+patient.getName()+"\nSymptoms: "+patient.getSymptom()+"\nDisease: "+patient.getDisease()+"\n\n");
                return display;
            }
            current = current.getLink();
        }
        return "Patient not found.";
}
    
    public String getPatientInformation() 
    {
        String display="";
        Node current = head;
        while (current != null) {
            Patients1 patient = current.getInfo();
            display+=("Name: "+patient.getName()+"\nSymptoms: "+patient.getSymptom()+"\nDisease: "+patient.getDisease()+"\n\n");
            current = current.getLink();
        }
    return display;
    }
    
    public String updateData(String name, String newSymptoms, String newDisease) {
        Node current = head;
        String display="";

        while (current != null) {
            Patients1 patient=(Patients1)current.getInfo();
            if (patient.getName().equals(name)) {
                // Found the matching node, update its information
                patient.setSymptom(newSymptoms);
                patient.setDisease(newDisease);
                display+="Data has been updated.\n"+patient.toString();
                return display;
            }
            else
                current = current.getLink();
        }
        // Node with the given name was not found
        return ("The data for " + name + " does not exist.");
    }

    private static class Node {
        private Patients1 info;
        private Node link;

        public Node(Patients1 info) {
            this.info = info;
            this.link = null;
        }

        public Patients1 getInfo() {
            return info;
        }

        public Node getLink() {
            return link;
        }

        public void setLink(Node link) {
            this.link = link;
        }
    }
}
