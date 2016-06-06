package lesson8;

public class ServiceRepository<Service> {
    private Service service;

    public ServiceRepository() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
