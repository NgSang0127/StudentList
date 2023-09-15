package model;

import java.util.ArrayList;

public class Province {

    private int idProvince;
    private String nameProvince;

    public Province(int idProvince, String nameProvince) {
        this.idProvince = idProvince;
        this.nameProvince = nameProvince;
    }


    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    @Override
    public String toString() {
        return "Province{" + "idProvince=" + idProvince + ", nameProvince='" + nameProvince + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Province province)) {
            return false;
        }

        if (getIdProvince() != province.getIdProvince()) {
            return false;
        }
        return getNameProvince() != null ? getNameProvince().equals(province.getNameProvince())
                : province.getNameProvince() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdProvince();
        result = 31 * result + (getNameProvince() != null ? getNameProvince().hashCode() : 0);
        return result;
    }

    public static ArrayList<Province> getListProvinceList() {
        String[] arr_province = {"Hà Giang", "Cao Bằng", "Lào Cai", "Sơn La", "Lai Châu", "Bắc Kạn", "Lạng Sơn",
                "Tuyên Quang", "Yên Bái", "Thái Nguyên", "Điện Biên", "Phú Thọ", "Vĩnh Phúc", "Bắc Giang", "Bắc Ninh",
                "Hà Nội", "Quảng Ninh", "Hải Dương", "Hải Phòng", "Hòa Bình", "Hưng Yên", "Hà Nam", "Thái Bình",
                "Nam Định", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Quảng Bình", "Quảng Trị", "Thừa Thiên Huế",
                "Đà Nẵng", "Quảng Nam", "Quảng Ngãi", "Kon Tum", "Gia Lai", "Bình Định", "Phú Yên", "Đắk Lắk",
                "Khánh Hòa", "Đắk Nông", "Lâm Đồng", "Ninh Thuận", "Bình Phước", "Tây Ninh", "Bình Dương", "Đồng Nai",
                "Bình Thuận", "Thành phố Hồ Chí Minh", "Long An", "Bà Rịa – Vũng Tàu", "Đồng Tháp", "An Giang",
                "Tiền Giang", "Vĩnh Long", "Bến Tre", "Cần Thơ", "Kiên Giang", "Trà Vinh", "Hậu Giang", "Sóc Trăng",
                "Bạc Liêu", "Cà Mau",};
        ArrayList<Province> listProvinces = new ArrayList<Province>();
        int i=0;
        for (String nameProvince : arr_province) {
            Province p=new Province(i,nameProvince);
            listProvinces.add(p);
        }
        return listProvinces;
    }
    public static Province getProvinceById(int birthPlace) {
        return Province.getListProvinceList().get(birthPlace);
    }
    public static Province getProvinceByName(String s) {
        ArrayList<Province> listProvinces = Province.getListProvinceList();
        for (Province p :listProvinces) {
            if(p.getNameProvince().equals(s)){
                return p;
            }
        }
        return null;
    }
}
