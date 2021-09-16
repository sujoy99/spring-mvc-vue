package com.infoworks.lab.domain.repository;

import com.infoworks.lab.client.jersey.HttpTemplate;
import com.infoworks.lab.domain.entities.Passenger;
import com.infoworks.lab.jsql.DataSourceKey;
import com.infoworks.lab.rest.models.Message;

public class PassengerRepository extends HttpTemplate<Passenger, Message> {

    public PassengerRepository() {
        super(Passenger.class, Message.class);
    }

    @Override
    protected String schema() {
        return "http://";
    }

    @Override
    protected String host() {
        return System.getenv("app.passenger.host");
    }

    @Override
    protected Integer port() {
        return Integer.valueOf(System.getenv("app.passenger.port"));
    }

    @Override
    protected String api() {
        return System.getenv("app.passenger.host");
    }

    public static DataSourceKey getKeyContainer(){
        //
        DataSourceKey container = new DataSourceKey();
        container.set(DataSourceKey.Keys.SCHEMA, "http://");
        //
        String host = System.getenv("app.passenger.host");
        container.set(DataSourceKey.Keys.HOST, host);
        //
        String port = System.getenv("app.passenger.port");
        container.set(DataSourceKey.Keys.PORT, port);
        //
        String name = System.getenv("app.passenger.api");
        container.set(DataSourceKey.Keys.NAME, name);
        //
        return container;
    }
}
