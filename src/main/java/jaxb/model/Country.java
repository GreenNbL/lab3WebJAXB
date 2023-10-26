package jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {

    private String nameOFCountry;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    /**
     * This default constructor is required if there are other constructors.
     */
    public Country () {

    }

    public Country(String countryName) {
        this.nameOFCountry = countryName;

    }

    public String getNameOFCountry() {
        return nameOFCountry;
    }

    public void setDeptNo(String countryName) {
        this.nameOFCountry = countryName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department>departments) {
        this.departments = departments;
    }

}