/*INSERT DE ROL CLIENTE*/
REPLACE INTO `role` VALUES (1,'CLIENTE');

/* INSERT DE MENUS*/

INSERT INTO `menu` (id,label,path,favicon,padre,prioridad) VALUES (1,'Productos','/productos','fas fa-archive',0,2),(2,'Marcas','/productos/marcas','fas fa-newspaper',1,2),(3,'Ventas','/ventas','fas fa-shopping-bag',0,2),(4,'Clientes','/ventas/clientes','fas fa-male',3,2),(5,'Empleados','/ventas/empleados/listEmpleados','fas fa-user',3,2),(6,'Puestos','/ventas/empleados/puestos/listPuestos','fas fa-address-card',5,2),(7,'Compras','/compras','fas fa-cart-arrow-down',0,2),(8,'Proveedores','/compras/proveedores','fas fa-users',7,2);