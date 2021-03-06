package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Yasemin Alpay on 20.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodItem {

    int offset;
    String group;
    String name;
    String ndbno;
    String ds;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNdbno() {
        return ndbno;
    }

    public void setNdbno(String ndbno) {
        this.ndbno = ndbno;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }
}
