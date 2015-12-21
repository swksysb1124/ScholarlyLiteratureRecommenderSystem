// @SOURCE:D:/citxtseer_v1/mainapp/conf/routes
// @HASH:2e7ccfbb488e7268dacdd05d4c872b260d27f94f
// @DATE:Thu Apr 24 21:06:45 EDT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:12
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:12
class ReverseAssets {
    

// @LINE:12
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def context(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "papers/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:7
def list(query:String = null , page:Integer = 1): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "papers" + queryString(List(if(query == null ) None else Some(implicitly[QueryStringBindable[String]].unbind("query", query)), if(page == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("page", page)))))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:12
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:12
class ReverseAssets {
    

// @LINE:12
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def context : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.context",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "papers/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:7
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.list",
   """
      function(query,page) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "papers" + _qS([(query == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("query", query)), (page == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("page", page))])})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:12
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:12
class ReverseAssets {
    

// @LINE:12
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def context(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.context(id), HandlerDef(this, "controllers.Application", "context", Seq(classOf[String]), "GET", """""", _prefix + """papers/$id<[^/]+>""")
)
                      

// @LINE:7
def list(query:String, page:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.list(query, page), HandlerDef(this, "controllers.Application", "list", Seq(classOf[String], classOf[Integer]), "GET", """""", _prefix + """papers""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    