import{u as oe,e as Ae,c as ee,f as z,I as le,b as se,_ as ie,i as Me}from"./index-BbGi8k9e.js";/* empty css              */import{f as ce,a6 as re,ak as De,a2 as e,j as r,s as d,t,y as a,v as l,x as i,p as U,k as ne,P as Fe,F as Ke,u as f,w as Oe,c as Be,r as He,a8 as We,ae as Je,o as Qe,M as Xe,N as Ye,E as $e,m as Ze}from"./libs-DaDHWX8D.js";import{c as et,d as tt,e as at}from"./data-Ch0vDAL7.js";import{b as Ue,c as pe,T as de,S as ue,a5 as nt,t as Ve,E as ot,am as lt,K as st,w as it,ao as ct,j as rt,D as pt,L as dt,B as ut,h as _t,N as gt,ap as ft,aq as mt,ar as bt,$ as yt,ai as ht,C as St}from"./arcoDesign-DkbNuMsn.js";import{I as wt}from"./index-Dfv4tBGb.js";import{I as kt}from"./index-BzQthmZB.js";const vt=ce({__name:"accessHistoryTable",props:{ip:{}},setup(te){const{t:u,d:s}=re(),$=oe(),{data:n,total:R,current:j,loading:I,pageSize:q,changeCurrent:b,changePageSize:A}=De(et,{defaultParams:[{ip:te.ip,page:1,pageSize:5}],pagination:{currentKey:"page",pageSizeKey:"pageSize",totalKey:"data.total"},cacheKey:_=>`${$.endpoint}-ipAccessHistory-${_==null?void 0:_[0].ip}-${(_==null?void 0:_[0].page)||1}-${(_==null?void 0:_[0].pageSize)||10}`}),D=[{title:()=>u("page.torrentList.accessHistory.column.downloader"),slotName:"downloader"},{title:"Peer ID",slotName:"peerId"},{title:()=>u("page.torrentList.accessHistory.column.traffic"),slotName:"traffic",width:120},{titleSlotName:"offsetTitle",slotName:"offset",width:120},{title:()=>u("page.dashboard.peerList.column.flag"),slotName:"flags",width:120},{title:()=>u("page.torrentList.accessHistory.column.timeseen"),slotName:"time",width:260},{title:()=>u("page.ipList.accessHistory.column.torrent"),dataIndex:"torrent.name",ellipsis:!0,tooltip:!0}],V=_=>_.split(" ").map(c=>c+" - "+u("page.dashboard.peerList.column.flags."+c.trim()));return(_,c)=>{var E,K;const ae=Ue,T=pe,w=le,k=de,h=se,y=ue,v=nt,g=Ve,F=ot;return(E=e(n))!=null&&E.data.results||e(I)?(r(),d(g,{key:0,stripe:!0,columns:D,data:(K=e(n))==null?void 0:K.data.results,loading:e(I),pagination:{total:e(R),current:e(j),pageSize:e(q),showPageSize:!0,baseSize:4,bufferSize:1},"column-resizable":"",size:"medium",bordered:!1,class:"banlog-table",onPageChange:e(b),onPageSizeChange:e(A)},{downloader:t(({record:o})=>[a(ae,{color:e(Ae)(o.downloader)},{default:t(()=>[l(i(o.downloader),1)]),_:2},1032,["color"])]),peerId:t(({record:o})=>[U("p",null,[l(i(o.peerId?o.peerId:e(u)("page.banlist.banlist.listItem.empty"))+" ",1),a(T,{content:o.clientName?o.clientName:e(u)("page.banlist.banlist.listItem.empty")},{default:t(()=>[a(e(ee))]),_:2},1032,["content"])])]),traffic:t(({record:o})=>[a(y,{fill:"",direction:"vertical"},{default:t(()=>[a(k,null,{default:t(()=>[a(w,{class:"green"}),l(" "+i(e(z)(o.uploaded)),1)]),_:2},1024),a(k,null,{default:t(()=>[a(h,{class:"red"}),l(" "+i(e(z)(o.downloaded)),1)]),_:2},1024)]),_:2},1024)]),offset:t(({record:o})=>[a(y,{fill:"",direction:"vertical"},{default:t(()=>[a(k,null,{default:t(()=>[a(w,{class:"green"}),l(" "+i(e(z)(o.uploadedOffset)),1)]),_:2},1024),a(k,null,{default:t(()=>[a(h,{class:"red"}),l(" "+i(e(z)(o.downloadedOffset)),1)]),_:2},1024)]),_:2},1024)]),offsetTitle:t(()=>[a(y,{size:"mini"},{default:t(()=>[l(i(e(u)("page.torrentList.accessHistory.column.offset"))+" ",1),a(v,{content:e(u)("page.torrentList.accessHistory.column.offsetDescription")},{default:t(()=>[a(e(ee))]),_:1},8,["content"])]),_:1})]),flags:t(({record:o})=>[U("p",null,[l(i(o.lastFlags)+" ",1),o.lastFlags?(r(),d(T,{key:0},{content:t(()=>[(r(!0),ne(Ke,null,Fe(V(o.lastFlags),G=>(r(),ne("p",{key:G},i(G),1))),128))]),default:t(()=>[a(e(ee))]),_:2},1024)):f("",!0)])]),time:t(({record:o})=>[a(y,{fill:"",direction:"vertical"},{default:t(()=>[a(k,null,{default:t(()=>[l(i(e(u)("page.torrentList.accessHistory.column.timeseen.first"))+": "+i(e(s)(o.firstTimeSeen,"long")),1)]),_:2},1024),a(k,null,{default:t(()=>[l(i(e(u)("page.torrentList.accessHistory.column.timeseen.last"))+": "+i(e(s)(o.lastTimeSeen,"long")),1)]),_:2},1024)]),_:2},1024)]),_:1},8,["data","loading","pagination","onPageChange","onPageSizeChange"])):(r(),d(F,{key:1,style:{height:"20vh","align-items":"center",display:"flex","justify-content":"center","flex-direction":"column"}},{default:t(()=>[l(i(e(u)("page.torrentList.accessHistory.empty")),1)]),_:1}))}}}),It=ie(vt,[["__scopeId","data-v-c343f774"]]),Tt=ce({__name:"banHistoryTable",props:{ip:{}},setup(te){const u=oe(),{t:s,d:$}=re(),{data:n,total:R,current:j,loading:I,pageSize:q,changeCurrent:b,changePageSize:A,refresh:D}=De(tt,{defaultParams:[{ip:te.ip,page:1,pageSize:10}],pagination:{currentKey:"page",pageSizeKey:"pageSize",totalKey:"data.total"},cacheKey:c=>`${u.endpoint}-banlogs-${(c==null?void 0:c[0].page)||1}-${(c==null?void 0:c[0].pageSize)||10}`});Oe(()=>u.endpoint,D);const V=[{title:()=>s("page.banlog.banlogTable.column.banTime")+"/"+s("page.banlog.banlogTable.column.unbanTime"),slotName:"banAt",width:220},{title:()=>s("page.banlog.banlogTable.column.peerPort"),dataIndex:"peerPort",width:80},{title:()=>s("page.banlog.banlogTable.column.peerId"),slotName:"peerId",width:120},{title:()=>s("page.banlog.banlogTable.column.trafficSnapshot"),slotName:"peerStatus",width:150},{title:()=>s("page.banlog.banlogTable.column.torrentName"),dataIndex:"torrentName",ellipsis:!0,tooltip:!0},{title:()=>s("page.banlog.banlogTable.column.torrentSize"),slotName:"torrentSize",width:120},{title:()=>s("page.banlog.banlogTable.column.description"),dataIndex:"description",ellipsis:!0,tooltip:!0}],_=Be(()=>{var c;return(c=n.value)==null?void 0:c.data.results});return(c,ae)=>{const T=wt,w=de,k=lt,h=ue,y=le,v=se,g=st,F=pe,E=ee,K=Ve;return r(),d(K,{stripe:!0,columns:V,data:_.value,loading:e(I),pagination:{total:e(R),current:e(j),pageSize:e(q),showPageSize:!0,baseSize:4,bufferSize:1},bordered:!1,"column-resizable":"",size:"medium",class:"banlog-table",onPageChange:e(b),onPageSizeChange:e(A)},{banAt:t(({record:o})=>[a(h,{fill:"",direction:"vertical"},{default:t(()=>[a(w,null,{default:t(()=>[a(T),l(" "+i(e($)(o.banAt,"long")),1)]),_:2},1024),a(w,null,{default:t(()=>[a(k),l(" "+i(o.unbanAt?e($)(o.unbanAt,"long"):e(s)("page.banlog.banlogTable.notUnbanned")),1)]),_:2},1024)]),_:2},1024)]),peerStatus:t(({record:o})=>[a(h,{fill:"",style:{"justify-content":"space-between"}},{default:t(()=>[a(h,{fill:"",direction:"vertical"},{default:t(()=>[a(w,null,{default:t(()=>[a(y,{class:"green"}),l(" "+i(e(z)(o.peerUploaded)),1)]),_:2},1024),a(w,null,{default:t(()=>[a(v,{class:"red"}),l(" "+i(e(z)(o.peerDownloaded)),1)]),_:2},1024)]),_:2},1024),a(F,{content:(o.peerProgress*100).toFixed(2)+"%"},{default:t(()=>[a(g,{percent:o.peerProgress,size:"mini"},null,8,["percent"])]),_:2},1032,["content"])]),_:2},1024)]),peerId:t(({record:o})=>[U("p",null,[l(i(o.peerId?o.peerId:e(s)("page.banlist.banlist.listItem.empty"))+" ",1),a(F,{content:o.peerClientName?o.peerClientName:e(s)("page.banlist.banlist.listItem.empty")},{default:t(()=>[a(E)]),_:2},1032,["content"])])]),torrentSize:t(({record:o})=>[a(F,{content:`Hash: ${o.torrentInfoHash}`},{default:t(()=>[U("p",null,i(e(z)(o.torrentSize)),1)]),_:2},1032,["content"])]),_:1},8,["data","loading","pagination","onPageChange","onPageSizeChange"])}}}),zt=ie(Tt,[["__scopeId","data-v-50b35476"]]),Lt={class:"center searchContainer"},Pt={class:"result-container center"},xt=ce({__name:"index",setup(te){const u=He(""),{t:s,d:$}=re(),{data:n,loading:R,run:j,error:I}=We(at,{manual:!0}),q=oe(),b=Be(()=>q.plusStatus),A=He([]),{query:D}=Je(),V=_=>{if(_){if(n.value=void 0,A.value=[],_!==D.ip){const c=new URLSearchParams(window.location.search);c.set("ip",_),window.history.pushState({},"",new URL(`${window.location.origin}${window.location.pathname}?${c.toString()}`))}j(_)}};return Qe(()=>{D.ip&&(u.value=D.ip,V(u.value))}),(_,c)=>{const ae=it,T=de,w=ct,k=rt,h=Ue,y=pe,v=ue,g=pt,F=le,E=se,K=ee,o=dt,G=ut,Ee=_t,_e=gt,ge=ft,fe=kt,me=mt,Re=bt,je=yt,qe=ht,Ge=St;return r(),d(v,{direction:"vertical",fill:"",class:"center"},{default:t(()=>{var be,ye;return[a(w,{style:{"text-align":"center"}},{default:t(()=>[a(ae,null,{default:t(()=>[l(i(e(s)("page.ipList.title")),1)]),_:1}),a(T,null,{default:t(()=>[l(i(e(s)("page.ipList.description")),1)]),_:1})]),_:1}),U("div",Lt,[a(k,{modelValue:u.value,"onUpdate:modelValue":c[0]||(c[0]=B=>u.value=B),"search-button":"",placeholder:"192.168.1.1....",class:"searchBox",loading:e(R),onSearch:V},null,8,["modelValue","loading"])]),U("div",Pt,[Xe(a(Ge,{class:"result-card",style:Ze({minWidth:(be=e(n))!=null&&be.data.found?"1150px":"400px"}),hoverable:""},{default:t(()=>[e(I)?(r(),d(qe,{key:1,status:"500",title:e(s)("page.ipList.error"),subtitle:e(I).message},{default:t(()=>[a(w,{style:{background:"var(--color-fill-2)",padding:"24px"}},{default:t(()=>{var B;return[a(je,null,{default:t(()=>c[7]||(c[7]=[l("Details:")])),_:1}),U("ul",null,[(r(!0),ne(Ke,null,Fe((B=e(I).stack)==null?void 0:B.split(`
`),m=>(r(),ne("li",{key:m},i(m),1))),128))])]}),_:1})]),_:1},8,["title","subtitle"])):(r(),d(v,{key:0,direction:"vertical",fill:""},{default:t(()=>{var B;return[a(Ee,null,{title:t(()=>[a(v,null,{default:t(()=>{var m,L;return[l(i((m=e(n))==null?void 0:m.data.address)+" ",1),(L=e(n))!=null&&L.data.found?f("",!0):(r(),d(y,{key:0,content:e(s)("page.ipList.notfound.tips")},{default:t(()=>[a(h,null,{default:t(()=>c[2]||(c[2]=[l("Not found")])),_:1})]),_:1},8,["content"]))]}),_:1})]),default:t(()=>{var m,L,M,O,P,x,C,he,Se,we,ke,ve,Ie,Te,ze,Le,Pe,xe,Ce,Ne;return[(m=e(n))!=null&&m.data.found?(r(),d(g,{key:0,label:e(s)("page.ipList.label.banCount"),span:2},{default:t(()=>{var p;return[l(i((p=e(n))==null?void 0:p.data.banCount),1)]}),_:1},8,["label"])):f("",!0),(L=e(n))!=null&&L.data.found?(r(),d(g,{key:1,label:e(s)("page.ipList.label.torrentAccessCount"),span:2},{default:t(()=>{var p;return[l(i((p=e(n))==null?void 0:p.data.torrentAccessCount),1)]}),_:1},8,["label"])):f("",!0),(M=e(n))!=null&&M.data.found?(r(),d(g,{key:2,label:e(s)("page.ipList.label.uploadedToPeer"),span:2},{default:t(()=>[a(T,null,{default:t(()=>{var p;return[a(F,{class:"green"}),l(" "+i(e(z)(((p=e(n))==null?void 0:p.data.uploadedToPeer)??0)),1)]}),_:1})]),_:1},8,["label"])):f("",!0),(O=e(n))!=null&&O.data.found?(r(),d(g,{key:3,label:e(s)("page.ipList.label.downloadedFromPeer"),span:2},{default:t(()=>[a(T,null,{default:t(()=>{var p;return[a(E,{class:"red"}),l(" "+i(e(z)(((p=e(n))==null?void 0:p.data.downloadedFromPeer)??0)),1)]}),_:1})]),_:1},8,["label"])):f("",!0),(P=e(n))!=null&&P.data.found?(r(),d(g,{key:4,label:e(s)("page.ipList.label.firstTimeSeen"),span:2},{default:t(()=>{var p;return[l(i(e($)(((p=e(n))==null?void 0:p.data.firstTimeSeen)??0,"long")),1)]}),_:1},8,["label"])):f("",!0),(x=e(n))!=null&&x.data.found?(r(),d(g,{key:5,label:e(s)("page.ipList.label.lastTimeSeen"),span:2},{default:t(()=>{var p;return[l(i(e($)(((p=e(n))==null?void 0:p.data.lastTimeSeen)??0,"long")),1)]}),_:1},8,["label"])):f("",!0),(Se=(he=(C=e(n))==null?void 0:C.data.geo)==null?void 0:he.country)!=null&&Se.iso||(ve=(ke=(we=e(n))==null?void 0:we.data.geo)==null?void 0:ke.city)!=null&&ve.name?(r(),d(g,{key:6,label:e(s)("page.banlist.banlist.listItem.geo"),span:2},{default:t(()=>{var p,S,W,J,Q,X,Y,Z;return[(S=(p=e(n).data.geo)==null?void 0:p.country)!=null&&S.iso?(r(),d(Me,{key:0,iso:((J=(W=e(n).data.geo)==null?void 0:W.country)==null?void 0:J.iso)??""},null,8,["iso"])):f("",!0),l(" "+i(`${((X=(Q=e(n).data.geo)==null?void 0:Q.country)==null?void 0:X.name)??""} ${((Z=(Y=e(n).data.geo)==null?void 0:Y.city)==null?void 0:Z.name)??""}`),1)]}),_:1},8,["label"])):f("",!0),(ze=(Te=(Ie=e(n))==null?void 0:Ie.data.geo)==null?void 0:Te.network)!=null&&ze.isp?(r(),d(g,{key:7,label:e(s)("page.banlist.banlist.listItem.network.isp"),span:1},{default:t(()=>{var p,S;return[l(i((S=(p=e(n).data.geo)==null?void 0:p.network)==null?void 0:S.isp),1)]}),_:1},8,["label"])):f("",!0),(xe=(Pe=(Le=e(n))==null?void 0:Le.data.geo)==null?void 0:Pe.network)!=null&&xe.netType?(r(),d(g,{key:8,label:e(s)("page.banlist.banlist.listItem.network.netType"),span:2},{default:t(()=>{var p,S;return[l(i((S=(p=e(n).data.geo)==null?void 0:p.network)==null?void 0:S.netType),1)]}),_:1},8,["label"])):f("",!0),(Ne=(Ce=e(n))==null?void 0:Ce.data.geo)!=null&&Ne.as?(r(),d(g,{key:9,label:e(s)("page.banlist.banlist.listItem.asn"),span:2},{default:t(()=>[a(v,null,{default:t(()=>{var p,S,W,J,Q,X,Y,Z;return[a(T,null,{default:t(()=>{var N,H;return[l(i((H=(N=e(n).data.geo)==null?void 0:N.as)==null?void 0:H.organization),1)]}),_:1}),a(h,{color:e(Ae)((((S=(p=e(n).data.geo)==null?void 0:p.as)==null?void 0:S.number)??0).toString())},{default:t(()=>{var N,H;return[l(i((H=(N=e(n).data.geo)==null?void 0:N.as)==null?void 0:H.number),1)]}),_:1},8,["color"]),a(y,{content:e(s)("page.banlist.banlist.listItem.asn.subnet")+((Q=(J=(W=e(n).data.geo)==null?void 0:W.as)==null?void 0:J.network)==null?void 0:Q.ipAddress)+"/"+((Z=(Y=(X=e(n).data.geo)==null?void 0:X.as)==null?void 0:Y.network)==null?void 0:Z.prefixLength)},{default:t(()=>{var N,H;return[a(o,{href:`https://2ip.io/analytics/asn-list/?asnId=${(H=(N=e(n).data.geo)==null?void 0:N.as)==null?void 0:H.number}`,hoverable:!1},{default:t(()=>[a(K)]),_:1},8,["href"])]}),_:1},8,["content"])]}),_:1})]),_:1},8,["label"])):f("",!0),a(g,{span:8},{label:t(()=>[a(v,null,{default:t(()=>[l(i(e(s)("page.ipList.shortcut"))+" ",1),a(y,{content:e(s)("page.ipList.shortcut.tips")},{default:t(()=>[a(K)]),_:1},8,["content"])]),_:1})]),default:t(()=>[a(v,null,{default:t(()=>[a(G,{href:`https://ip.ping0.cc/ip/${u.value}`,type:"outline"},{default:t(()=>c[3]||(c[3]=[l(" ping0 ")])),_:1},8,["href"]),a(G,{href:`https://search.censys.io/hosts/${u.value}`,type:"outline"},{default:t(()=>c[4]||(c[4]=[l(" Censys ")])),_:1},8,["href"])]),_:1})]),_:1})]}),_:1}),(B=e(n))!=null&&B.data.found?(r(),d(Re,{key:0,"active-key":A.value,"onUpdate:activeKey":c[1]||(c[1]=m=>A.value=m),bordered:!1,"destroy-on-hide":""},{default:t(()=>{var m,L,M,O;return[a(me,{key:"1",header:e(s)("page.ipList.label.accessHistory"),disabled:!((m=b.value)!=null&&m.activated),class:"collapse-table"},$e({"expand-icon":t(({active:P})=>{var x,C;return[(x=b.value)!=null&&x.activated&&!P?(r(),d(_e,{key:0})):(C=b.value)!=null&&C.activated&&P?(r(),d(ge,{key:1})):(r(),d(fe,{key:2}))]}),default:t(()=>[a(It,{ip:e(n).data.address},null,8,["ip"])]),_:2},[(L=b.value)!=null&&L.activated?void 0:{name:"extra",fn:t(()=>[a(y,{content:e(s)("page.ipList.plusLock")},{default:t(()=>[a(h,{size:"small"},{default:t(()=>c[5]||(c[5]=[l("Plus")])),_:1})]),_:1},8,["content"])]),key:"0"}]),1032,["header","disabled"]),a(me,{key:"2",header:e(s)("page.ipList.label.banHistory"),disabled:!((M=b.value)!=null&&M.activated),class:"collapse-table"},$e({"expand-icon":t(({active:P})=>{var x,C;return[(x=b.value)!=null&&x.activated&&!P?(r(),d(_e,{key:0})):(C=b.value)!=null&&C.activated&&P?(r(),d(ge,{key:1})):(r(),d(fe,{key:2}))]}),default:t(()=>[a(zt,{ip:e(n).data.address},null,8,["ip"])]),_:2},[(O=b.value)!=null&&O.activated?void 0:{name:"extra",fn:t(()=>[a(y,{content:e(s)("page.ipList.plusLock")},{default:t(()=>[a(h,{size:"small"},{default:t(()=>c[6]||(c[6]=[l("Plus")])),_:1})]),_:1},8,["content"])]),key:"0"}]),1032,["header","disabled"])]}),_:1},8,["active-key"])):f("",!0)]}),_:1}))]),_:1},8,["style"]),[[Ye,((ye=e(n))==null?void 0:ye.data)||e(I)]])])]}),_:1})}}}),Kt=ie(xt,[["__scopeId","data-v-a0fbeb26"]]);export{Kt as default};
