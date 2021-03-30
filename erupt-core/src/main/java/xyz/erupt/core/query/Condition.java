package xyz.erupt.core.query;

import lombok.Data;
import xyz.erupt.annotation.config.QueryExpression;

@Data
public class Condition {

    private String key;

    private Object value;

    private transient QueryExpression expression = QueryExpression.EQ;

    public Condition(String key, Object value, QueryExpression expression) {
        this.key = key;
        this.value = value;
        this.expression = expression;
    }

    public Condition(String key, Object value) {
        this.key = key;
        this.value = value;
    }

}
