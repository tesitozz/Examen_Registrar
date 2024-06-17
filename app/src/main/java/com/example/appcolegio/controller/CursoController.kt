package com.example.appcolegio.controller

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.appcolegio.entidad.Curso
import com.example.appcolegio.utils.appConfig

class CursoController {

    //Funcion para retornar un arreglo de objetos de la clase Docente
    fun findAll():ArrayList<Curso>{

        //Crear arreglo de objetos
        var data=ArrayList<Curso>()

        //Adicionar 1 curso dentro del arreglo data
        //data.add(Curso(1,"Programacion",140.0,14,"Ingenieria","d4"))

        //Acceder a la base de datos en modo lectura(valor de retorno de SQLIteDatabase)
        var CN=appConfig.BD.readableDatabase

        //Sentencia SQL

        var sql= "select *from tb_curso"

        //Obtener datos de la tabla docente
        var RS=CN.rawQuery(sql,null)

        //Bucle para realizar recorrido sobre RS

        while (RS.moveToNext()){
            var bean=Curso(RS.getInt(0),
                RS.getString(1),
                RS.getDouble(2),
                RS.getInt(3),
                RS.getString(4),
                RS.getString(5))

            data.add(bean)
        }
        return data
    }

    fun save(bean:Curso):Int{
        var estado=-1

        //Acceder a la base de datos en modo escritura

        var CN= appConfig.BD.writableDatabase

        //Objeto de la clase ContentValues

        var data= ContentValues()

        //Asignar claves(Nombres de campos de la tabla tb_curso)

        data.put("nomCurso",bean.nombreCurso)
        data.put("credito",bean.credito)
        data.put("horas",bean.horas)
        data.put("carrera",bean.carrera)
        data.put("foto",bean.foto)
        estado=CN.insert("tb_curso","cod",data).toInt()
        return estado
    }
}