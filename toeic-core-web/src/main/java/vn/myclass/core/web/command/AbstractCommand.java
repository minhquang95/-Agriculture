package vn.myclass.core.web.command;

import java.util.List;

public class AbstractCommand<T>  {
    protected T pojo;
    private String typeUrl;

    public String getTypeUrl() {
        return typeUrl;
    }

    public void setTypeUrl(String typeUrl) {
        this.typeUrl = typeUrl;
    }

    public T getPojo() {
        return pojo;
    }

    public void setPojo(T pojo) {
        this.pojo = pojo;
    }


}
