-- query para crear la base de datos y algunos datos

create database inventario;
use inventario;

-- !Antes de insertar los datos ejecutar el proyecto una vez para que se cree la tabla!

INSERT INTO `inventario`.`producto` (`id`, `categoria`, `fecha_creacion`, `marca`, `nombre`, `precio`) VALUES
(1, 'televisor', '2024-05-04', 'LG', '4K UHD 55"', '4500000'),
(2, 'televisor', '2024-05-04', 'Samsung', 'Smart TV 65"', '6200000'),
(3, 'telefono', '2024-05-04', 'Apple', 'iPhone 13 Pro Max', '3500000'),
(4, 'telefono', '2024-05-04', 'Samsung', 'Galaxy S22 Ultra', '2800000'),
(5, 'telefono', '2024-05-04', 'Xiaomi', '12 Pro', '2100000'),
(6, 'impresora', '2024-05-04', 'HP', 'LaserJet Pro M404dw', '800000'),
(7, 'impresora', '2024-05-04', 'Brother', 'MFC-L2710DW', '420000');