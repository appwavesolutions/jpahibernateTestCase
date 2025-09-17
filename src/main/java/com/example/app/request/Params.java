package com.example.app.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true
)
@JsonSubTypes({
	@JsonSubTypes.Type(value = CreateAccountParams.class, name = "CreateAccountParams"),
	@JsonSubTypes.Type(value = PlaceOrderParams.class, name = "PlaceOrderParams"),
	@JsonSubTypes.Type(value = SendEmailParams.class, name = "SendEmailParams")
})
public abstract class Params {
}
