// @SOURCE:D:/citxtseer_v1/mainapp/conf/routes
// @HASH:2e7ccfbb488e7268dacdd05d4c872b260d27f94f
// @DATE:Thu Apr 24 21:06:45 EDT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_list1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("papers"))))
        

// @LINE:8
private[this] lazy val controllers_Application_context2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("papers/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_Assets_at3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """papers""","""controllers.Application.list(query:String ?= null , page:Integer ?= 1)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """papers/$id<[^/]+>""","""controllers.Application.context(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_list1(params) => {
   call(params.fromQuery[String]("query", Some(null )), params.fromQuery[Integer]("page", Some(1))) { (query, page) =>
        invokeHandler(controllers.Application.list(query, page), HandlerDef(this, "controllers.Application", "list", Seq(classOf[String], classOf[Integer]),"GET", """""", Routes.prefix + """papers"""))
   }
}
        

// @LINE:8
case controllers_Application_context2(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Application.context(id), HandlerDef(this, "controllers.Application", "context", Seq(classOf[String]),"GET", """""", Routes.prefix + """papers/$id<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     