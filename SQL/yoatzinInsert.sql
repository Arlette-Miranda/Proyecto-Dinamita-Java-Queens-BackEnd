-- Inserciones para la tabla `yoatzin`.`privileges`
INSERT INTO `yoatzin`.`privileges` (`privilege`,`description`) VALUES
-- Agregar columna de descripción
('gerencia','Persona que está a cargo de la dirección y coordinación de la empresa/organización, tendrá acceso a la visualización de todos los datos generados en la aplicación.'),
('cliente','Persona que ingresa a al aplicación para adquirir productos a traves del registro, así como a dejar comentarios.'),
('admin_almacen','Persona encargada de actualizar el inventario de productos en existencia.'),
('admin_general','Persona encargada de la administración de todos los departamentos, así como actualización de precios.'),
('desarrollador','Persona encargada de el desarrollo y funcionalidad del sitio web.');

-- Inserciones para la tabla `yoatzin`.`sizes`
INSERT INTO `yoatzin`.`sizes` (`size`) VALUES
('XS'),
('S'),
('M'),
('L'),
('XL'),
('Unitalla');

-- Inserciones para la tabla `yoatzin`.`users`
INSERT INTO `yoatzin`.`users` (`name`, `last_name`, `phone`, `email`, `password`, `fk_id_privilege`) VALUES
('Carlos', 'Mendoza Ruíz', 5551234567, 'carlos.mendoza@example.com', 'password1', 1),
('Laura', 'Gómez Pérez', 5552345678, 'laura.gomez@example.com', 'password2', 2),
('Sofia', 'Martínez Pineda', 5553456789, 'sofia.martinez@example.com', 'password3', 3),
('Jorge', 'Ramírez Sánchez', 5554567890, 'jorge.ramirez@example.com', 'password4', 4),
('Ana', 'Cruz Atienza', 5555678901, 'ana.cruz@example.com', 'password5', 2),
('Juan Roberto', 'Fernández Rodríguez', 5556789012, 'roberto.fernandez@example.com', 'password6', 2),
('María', 'Gonzalez López', 5567852618, 'maria.gonzalez@example.com', 'password7', 5);

-- Inserciones adicionales para la tabla `yoatzin`.`cards`
INSERT INTO `yoatzin`.`cards` (`number`, `owner_card`, `month`, `year`, `cvc`,`fk_id_user`) VALUES
(1234567812345678, 'Laura Gómez Pérez', 12, 2025, 123,2),
(8765432187654321, 'Julieta Fierro Domínguez', 6, 2024, 456,2),
(2345678923456789, 'Ana Cruz Atienza', 3, 2026, 789,5),
(3456789034567890, 'Juan Roberto Fernández Rodríguez', 11, 2024, 012,6),
(4567890145678901, 'Emily Pérez Sánchez', 8, 2025, 345,5);

-- Inserciones adicionales para la tabla `yoatzin`.`addresses`
INSERT INTO `yoatzin`.`addresses` (`state`, `city`, `colony`, `street`, `zipcode`, `reference`,`fk_id_user`) VALUES
('Ciudad de México', 'Cuauhtémoc', 'Roma Norte', 'Avenida Insurgentes', 06700, 'Cerca de Plaza Insurgentes',2),
('Jalisco', 'Guadalajara', 'Zapata', 'Avenida Vallarta', 44100, 'A un lado de Starbucks',2),
('Nuevo León', 'Monterrey', 'San Pedro', 'Avenida Alfonso Reyes', 66260, 'Cerca de Parque Hundido',5),
('Yucatán', 'Mérida', 'Centro', 'Calle 60', 97000, 'Cruzando la Plaza Principal',5),
('Puebla', 'Puebla', 'Angelópolis', 'Boulevard Atlixco', 72570, 'Junto a la Plaza Angelópolis',6);

-- Inserciones para la tabla `yoatzin`.`orders`
INSERT INTO `yoatzin`.`orders` (`quantity`, `date`, `fk_id_user`, `fk_id_card`, `fk_id_address`) VALUES
(1, '2024-07-30 08:00:00', 2, 1, 1), -- Laura Gómez Pérez --
(2, '2024-07-30 09:30:00', 5, 3, 4), -- Ana Cruz Atienza
(1, '2024-07-30 11:00:00', 6, 4, 5), -- Juan Roberto Fernández Rodríguez
(3, '2024-07-30 12:30:00', 2, 1, 1), -- Laura Gómez Pérez
(1, '2024-07-30 14:00:00', 5, 3, 4); -- Ana Cruz Atienza

-- Inserciones para la tabla `yoatzin`.`products`
INSERT INTO `yoatzin`.`products` (`name`, `category`, `price`, `image`, `origin`, `stock`, `description`, `fk_id_size`) VALUES
('Vaso de Barro', 'Cerámica', 15.00, '/img/vaso de barro negro.jpg', 'Oaxaca, México', 50, 'Elegante vaso de barro negro meticulosamente decorado con delicadas flores, creando una obra de arte funcional que combina tradición y belleza. Cada flor está cuidadosamente pintada a mano por nuestros artesanos oaxaqueños, resaltando detalles vívidos y colores contrastantes que resaltan sobre el fondo. Ofrece una experiencia táctil única que es ideal tanto como pieza decorativa como para su uso diario, este vaso añadirá un toque de distinción y autenticidad a cualquier ambiente.', 6),
('Sombrero de Palma', 'Textiles', 20.00, '/img/sombrero de palma.jpg', 'Yucatán, México', 50, 'Este encantador sombrero está tejido a mano con palma natural de las regiones de Yucatán, ofreciendo un estilo clásico y funcionalidad ideal para días soleados. Su diseño ligero y transpirable proporciona comodidad durante horas, mientras que el tejido artesanalmente asegura durabilidad y resistencia. Elaborado con materiales naturales y un cuidado artesanal, cada sombrero es único, reflejando la habilidad y la tradición de los artesanos que lo crearon.', 6),
('Bolsa de Mimbre', 'Textiles', 25.00, '/img/bolsa de mimbre.jpg', 'Chiapas, México', 50, 'Esta encantadora bolsa de mimbre fusiona elegancia y tradición con su diseño mexicano auténtico de Chiapas. El mimbre tejido a mano ofrece una estructura robusta y ligera, perfecta para llevar tus pertenencias con estilo. Decorada con detalles típicos mexicanos como bordados vibrantes, pompones coloridos y figuras geométricas inspiradas en la artesanía tradicional, cada bolsa es una obra de arte única. Su tamaño espacioso y práctico la convierte en un accesorio versátil para el día a día.', 6),
('Tapete de Lana', 'Textiles', 50.00, '/img/tapete de lana.jpg', 'Zacatecas, México', 50, 'Este exquisito tapete de lana combina la calidez y la suavidad natural con un diseño decorativo que realza cualquier espacio. Tejido a mano con técnicas tradicionales de Zacatecas, cada detalle en su patrón está meticulosamente trabajado para crear una obra de arte funcional. Los colores ricos y las texturas sutiles resaltan el trabajo artesanal, mientras que el decorativo de flores, añade un toque de elegancia y estilo. Este tapete no solo proporciona confort bajo los pies, sino que también se convierte en el punto focal de cualquier habitación, reflejando el cuidado y la habilidad de los artesanos que lo crearon. Perfecto para añadir calidez y personalidad a tu hogar.', 6),
('Máscara de Madera', 'Decoración', 30.00, '/img/mascara de madera.jpg', 'Guerrero, México', 50, 'Esta impresionante máscara de madera mexicana es una expresión vibrante de la rica cultura y tradición artesanal del Estado de Guerrero. Tallada a mano por hábiles artesanos, cada detalle de esta máscara refleja el profundo simbolismo y la historia que envuelve la iconografía mexicana. Los colores brillantes y los patrones intrincados pintados a mano resaltan contra el fondo de madera natural, creando una obra de arte única y cautivadora.', 3);

-- Inserciones para la tabla `yoatzin`.`comments`
INSERT INTO `yoatzin`.`comments` (`comment`, `fk_id_user`) VALUES
('Gran producto. Compra muy rápida', 2),
('Voy a compartir este producto a todos mis conocidos. Está genial!', 2),
('Excelente servicio. Me encantó el color azul. 5 estrellas', 5),
('Me encanta el diseño de esta bolsa artesanal', 5),
('Recomiendo este producto', 6);

-- Inserciones para la tabla `yoatzin`.`products_has_orders`
INSERT INTO `yoatzin`.`products_has_orders` (`id_product`, `id_order`, `partial_amount`,`discount`, `shipment`, `final_amount`) VALUES
-- Para la orden 1 (Laura Gómez Pérez)
(1, 1, 15.00, 1.50, 0.00, 13.50), -- Vaso de Barro
-- Para la orden 2 (Ana Cruz Atienza)
(2, 2, 20.00, 2.00, 0.00, 18.00), -- Sombrero de Palma
(3, 2, 25.00, 2.50, 0.00, 22.50), -- Bolsa de Mimbre
-- Para la orden 3 (Juan Roberto Fernández Rodríguez)
(4, 3, 50.00, 5.00, 0.00, 45.00), -- Tapete de Lana
-- Para la orden 4 (Laura Gómez Pérez)
(1, 4, 15.00, 1.50, 0.00, 13.50), -- Vaso de Barro
(3, 4, 25.00, 2.50, 0.00, 22.50), -- Bolsa de Mimbre
(4, 4, 50.00, 5.00, 0.00, 45.00), -- Tapete de Lana
-- Para la orden 5 (Ana Cruz Atienza)
(2, 5, 20.00, 2.00, 0.00, 18.00); -- Sombrero de Palma

