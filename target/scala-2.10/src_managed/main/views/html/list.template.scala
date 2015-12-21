
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object list extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[List[Paper],Integer,Integer,Integer,Integer,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/( paged_papers: List[Paper], offset: Integer, upper: Integer, total: Integer, page: Integer, query: String ):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.110*/("""

"""),_display_(Seq[Any](/*3.2*/main("CitxtSeer")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
    
    """),_display_(Seq[Any](/*5.6*/if(flash.containsKey("success"))/*5.38*/ {_display_(Seq[Any](format.raw/*5.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*7.37*/flash/*7.42*/.get("success"))),format.raw/*7.57*/("""
        </div>
    """)))})),format.raw/*9.6*/(""" 

    <div id="actions">
        
        <form action="/papers" method="GET"> <!--action 改成"/???", 由form action去呼叫routes進行動作 -->
            <input type="search" id="searchbox" name="query" placeholder="Search by query..."> <!--f 改成 query, value 沒有沒關係 -->
            <input type="submit" id="searchsubmit" value="Search" class="btn primary">
        </form>
                
    </div>
    <!-- 以下是search engine 結果呈現方式 -->
    """),_display_(Seq[Any](/*20.6*/if(paged_papers.size() == 0)/*20.34*/ {_display_(Seq[Any](format.raw/*20.36*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))}/*26.7*/else/*26.12*/{_display_(Seq[Any](format.raw/*26.13*/("""
			<div id="result_info",>
			<p style="background-color:rgb(146,205,220);">
			   	<Strong>"""),_display_(Seq[Any](/*29.17*/{offset+1})),format.raw/*29.27*/(""" - """),_display_(Seq[Any](/*29.31*/upper)),format.raw/*29.36*/("""</Strong> of <Strong>"""),_display_(Seq[Any](/*29.58*/total)),format.raw/*29.63*/("""</Strong> Results
			</p>
	    	</div>
			<div id="result_list">
				<!-- 將currentPage.getList 所產出的 Computer List 列出 , 我們的case是 paper list。將List資料存成computer物件 -->
                """),_display_(Seq[Any](/*34.18*/for(paper <- paged_papers) yield /*34.44*/ {_display_(Seq[Any](format.raw/*34.46*/("""
						<h3>
							<a href=""""),_display_(Seq[Any](/*36.18*/routes/*36.24*/.Application.context(paper.id))),format.raw/*36.54*/("""">"""),_display_(Seq[Any](/*36.57*/paper/*36.62*/.title)),format.raw/*36.68*/(""" </a> 
						</h3>
						
						<div class="pubinfo">
							<span class="authors"> by <i>"""),_display_(Seq[Any](/*40.38*/paper/*40.43*/.authors)),format.raw/*40.51*/("""</i></span>                  		
							<span class="pubvenue"> """),_display_(Seq[Any](/*41.33*/paper/*41.38*/.pubvenue)),format.raw/*41.47*/("""</span>
							<span class="pubyear">, """),_display_(Seq[Any](/*42.33*/paper/*42.38*/.year)),format.raw/*42.43*/(""" .</span>
						</div>

						<div class="pubextras"> 
						<a class="abstract_toggle"> <strong> Abstract </strong> </a>
							-
							<a class="citation remove" href="http://citeseerx.ist.psu.edu/showciting?doi="""),_display_(Seq[Any](/*48.86*/paper/*48.91*/.id)),format.raw/*48.94*/("""" title="number of citations">
									Cited by """),_display_(Seq[Any](/*49.20*/paper/*49.25*/.ncites)),format.raw/*49.32*/(""" ("""),_display_(Seq[Any](/*49.35*/paper/*49.40*/.selfCites)),format.raw/*49.50*/(""" self) </a>
							-
							<a>Like</a>
							<div class="pubabstract"> """),_display_(Seq[Any](/*52.35*/paper/*52.40*/.abst)),format.raw/*52.45*/(""" </div>
						</div>
						<hr>
                """)))})),format.raw/*55.18*/("""
			</div>
            </tbody>
		<!-- -->
		<!-- 以下是分頁呈現方式 -->
		<div class="sb_pag">
				"""),_display_(Seq[Any](/*61.6*/if(page>1)/*61.16*/{_display_(Seq[Any](format.raw/*61.17*/("""
					<a href=""""),_display_(Seq[Any](/*62.16*/routes/*62.22*/.Application.list(query,(page-1)))),format.raw/*62.55*/("""">Prev</a>
					"""),_display_(Seq[Any](/*63.7*/for(i <- math.max(1,page-5) until page) yield /*63.46*/ {_display_(Seq[Any](format.raw/*63.48*/("""
						<a href=""""),_display_(Seq[Any](/*64.17*/routes/*64.23*/.Application.list(query,i))),format.raw/*64.49*/("""">"""),_display_(Seq[Any](/*64.52*/i)),format.raw/*64.53*/("""</a>
					""")))})),format.raw/*65.7*/("""
				""")))})),format.raw/*66.6*/(""" 
				- <a class="sb_pagS">"""),_display_(Seq[Any](/*67.27*/page)),format.raw/*67.31*/("""</a>
				"""),_display_(Seq[Any](/*68.6*/if(page<(total.toDouble/10.0).ceil.toInt)/*68.47*/ {_display_(Seq[Any](format.raw/*68.49*/("""
					"""),_display_(Seq[Any](/*69.7*/for(i <- page+1 to math.min((total.toDouble/10.0).ceil.toInt, page+4)) yield /*69.77*/ {_display_(Seq[Any](format.raw/*69.79*/("""
						<a href=""""),_display_(Seq[Any](/*70.17*/routes/*70.23*/.Application.list(query,i))),format.raw/*70.49*/("""">"""),_display_(Seq[Any](/*70.52*/i)),format.raw/*70.53*/("""</a>
					""")))})),format.raw/*71.7*/("""
					<a href=""""),_display_(Seq[Any](/*72.16*/routes/*72.22*/.Application.list(query,(page+1)))),format.raw/*72.55*/("""">Next</a>
				""")))})),format.raw/*73.6*/("""
		</div>
		
    """)))})),format.raw/*76.6*/("""
        
""")))})),format.raw/*78.2*/("""

            """))}
    }
    
    def render(paged_papers:List[Paper],offset:Integer,upper:Integer,total:Integer,page:Integer,query:String): play.api.templates.HtmlFormat.Appendable = apply(paged_papers,offset,upper,total,page,query)
    
    def f:((List[Paper],Integer,Integer,Integer,Integer,String) => play.api.templates.HtmlFormat.Appendable) = (paged_papers,offset,upper,total,page,query) => apply(paged_papers,offset,upper,total,page,query)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 24 23:24:35 EDT 2014
                    SOURCE: D:/citxtseer_v1/mainapp/app/views/list.scala.html
                    HASH: ac20578874221e775934a2b8bde849575e8a8869
                    MATRIX: 817->1|1020->109|1057->112|1082->129|1121->131|1166->142|1206->174|1245->176|1361->257|1374->262|1410->277|1461->298|1927->729|1964->757|2004->759|2128->866|2141->871|2180->872|2310->966|2342->976|2382->980|2409->985|2467->1007|2494->1012|2710->1192|2752->1218|2792->1220|2857->1249|2872->1255|2924->1285|2963->1288|2977->1293|3005->1299|3132->1390|3146->1395|3176->1403|3276->1467|3290->1472|3321->1481|3397->1521|3411->1526|3438->1531|3690->1747|3704->1752|3729->1755|3815->1805|3829->1810|3858->1817|3897->1820|3911->1825|3943->1835|4053->1909|4067->1914|4094->1919|4175->1968|4302->2060|4321->2070|4360->2071|4412->2087|4427->2093|4482->2126|4534->2143|4589->2182|4629->2184|4682->2201|4697->2207|4745->2233|4784->2236|4807->2237|4849->2248|4886->2254|4950->2282|4976->2286|5021->2296|5071->2337|5111->2339|5153->2346|5239->2416|5279->2418|5332->2435|5347->2441|5395->2467|5434->2470|5457->2471|5499->2482|5551->2498|5566->2504|5621->2537|5668->2553|5717->2571|5759->2582
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|48->20|48->20|48->20|54->26|54->26|54->26|57->29|57->29|57->29|57->29|57->29|57->29|62->34|62->34|62->34|64->36|64->36|64->36|64->36|64->36|64->36|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|76->48|76->48|76->48|77->49|77->49|77->49|77->49|77->49|77->49|80->52|80->52|80->52|83->55|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|93->65|94->66|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|98->70|98->70|99->71|100->72|100->72|100->72|101->73|104->76|106->78
                    -- GENERATED --
                */
            