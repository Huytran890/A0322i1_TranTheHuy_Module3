package utils;

public interface ProductConstants {
    String INSET_PRODUCT = "insert into product (name, price, quantity, color, description, id_category) values (?,?,?,?,?,?)";
    String UPDATE_PRODUCT = "update product set name=?, price=?, quantity=?, color=?, description=?, id_category=? where id_product=?";
    String DELETE_PRODUCT = "delete from product where id_product=?";

    String SELECT_PRODUCT_COMBINE = "select p.id_product, p.name, p.price, p.quantity, p.color, p.description, c.id_category, c.name_category from product p inner join category c on p.id_category= c.id_category";
    String SEARCH_PRODUCT_COMBINE = "select p.id_product, p.name, p.price, p.quantity, p.color, p.description, c.id_category, c.name_category from product p inner join category c on p.id_category= c.id_category where id_product=?";
    String SEARCH_ALL_PRODUCT_COMBINE = "select p.id_product, p.name, p.price, p.quantity, p.color, p.description, c.id_category, c.name_category from product p inner join category c on p.id_category= c.id_category where p.name like?";

    String SORT_PRODUCTS_BY_NAME = "select p.id_product, p.name, p.price, p.quantity, p.color, p.description, c.id_category, c.name_category from product p inner join category c on p.id_category= c.id_category Order By name ASC";
}
