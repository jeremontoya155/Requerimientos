from flask_mysqldb import MySQL
from flask import Flask, render_template, request, redirect, url_for, flash


app = Flask(__name__)


# Pasamos las configuraciones al mysql
app.config["MYSQL_HOST"] = "localhost"
app.config["MYSQL_USER"] = "root"
app.config["MYSQL_PASSWORD"] = ""
app.config["MYSQL_DB"] = "Requerimiento"

mysql = MySQL(app)


# Iniciamos una sesion
app.secret_key = "mysecretkey"


@app.route("/")
def index():
    cur = mysql.connection.cursor()
    cur.execute("SELECT * FROM ejemplar")
    data = cur.fetchall()
    print(data)
    return render_template("index.html", datos=data)


@app.route("/add_person", methods=["POST"])
def add_contact():
    if request.method == "POST":
        id = request.form["id"]
        author = request.form["author"]
        field_l = request.form["field_l"]
        description = request.form["description"]
        my_numeric_field = request.form["my_numeric_field"]
        cur = mysql.connection.cursor()
        cur.execute(
            "INSERT INTO  ejemplar(id,field_l,author,descripcion,my_numeric_field) VALUES(%s, %s, %s,%s,%s)",
            (id, field_l, author, description, my_numeric_field),
        )
        mysql.connection.commit()
        # Aca llamamos a la funcion no a la pagina
        flash("Contacto agregado")
        return redirect(url_for("index"))


@app.route("/delete/<string:id>")
def delete(id):
    cur = mysql.connection.cursor()
    cur.execute("DELETE FROM ejemplar WHERE id={0}".format(id))
    mysql.connection.commit()
    flash("Eliminamos el contacto")
    return redirect(url_for("index"))


@app.route("/data/1 ")
def FuncionUno():
    flash("Se deja en value para cargar caso uno")
    return render_template("ejemploUno.html")


@app.route("/data/2 ")
def FuncionDos():
    flash("Se deja en value para cargar caso dos")
    return render_template("ejemploDos.html")


@app.route("/input/my_numeric_field")
def FuncionTres():
    return render_template("ejemploTres.html")


@app.route("/input/my_numeric_field", methods=["POST"])
def accionTres():
    flash(
        '{ "error": "my_numeric_field no es un campo válido para convertir a mayúscula"}'
    )
    return redirect(url_for("index"))


@app.route("/input/random_field")
def FuncionCuatro():
    return render_template("ejemploCuatro.html")


@app.route("/input/random_field", methods=["POST"])
def accionCuatro():
    flash('{ "error": "random_field no es un campo válido para convertir a mayúscula"}')
    return redirect(url_for("index"))


@app.errorhandler(404)
def page_not_found(error):
    return render_template("error.html"), 404


if __name__ == "__main__":
    app.run(port=3000, debug=True)
