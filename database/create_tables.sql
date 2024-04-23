-- Creation of table
CREATE TABLE IF NOT EXISTS modules (
  module_id INT NOT NULL,
  description varchar(250) NOT NULL,
  c_p INT NOT NULL,
  PRIMARY KEY (module_id)
);
