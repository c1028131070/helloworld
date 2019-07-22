/*$(document).ready(function () {
  var keyword = GetQueryString("key");
  getproduct(0,0,keyword);

})*/
var PAGE_SIZE = 10;

function GetQueryString(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
  if (r != null) return unescape(decodeURI(r[2]));
  return null;
}
var vm4 = new Vue({
  el: "#filter",
  data: {
    keyword: ""
  },
  methods: {
    mallFilter: function (e) {
      // console.log(e.target.value)
      var str = '';
      $("input:checkbox[class='mallfilter']:checked").each(function () {
        var val = $(this).val();
        str = str + val + ",";
      })
      console.log("str: " + str)
      var keyword = vm4.keyword;
      getproduct(0, PAGE_SIZE, keyword, str);
    }

  }
})

var vm3 = new Vue({
  el: "#app",
  data: {
    current: "",
    allpage: "",
    showItem: "",
    hackReset:true
  },
  methods: {
    reload: function () {
      console.log('current:'+this.current)
      console.log('allpage：'+this.allpage)
      console.log('showItem：'+this.showItem)
      vm3.hackReset = false;
      this.$nextTick(() => {
        vm3.hackReset = true
      })
    }
  }
})
var vm = new Vue({
  el: "#productContent",
  data: {
    productContent: "",
    total: "",
    seen: false
  },
  created: function () {
    var keyword = '小米9';
    getproduct(0, 10, keyword);
  },
  methods: {
    enter(index) {
      console.log("enter")
      var myChart = echarts.init(document.getElementsByClassName('priceLine')[index]);
      myChart.setOption(option);
      var productId = document.getElementsByClassName('priceLine')[index].getAttribute("data-productId")
      getEchartData(productId, myChart);
      document.getElementsByClassName('priceLine')[index].setAttribute("z-index", 1);
      this.seen = true;
    },
    leave(index) {
      console.log("leave")
      echarts.dispose(document.getElementsByClassName('priceLine')[index])
      document.getElementsByClassName('priceLine')[index].setAttribute("z-index", 0);
      this.seen = false;
    }
  }
})

var vm1 = new Vue({
  el: "#productNum",
  data: {
    productNum: ""
  }
})


var vm2 = new Vue({
  el: "#search",
  methods: {
    clickSearch: function () {
      var keyword = '小米';
      keyword = $("#keyword").val();
      //取消选中
      $("[class='mallfilter']").removeAttr("checked");
      getproduct(0, 10, keyword);
    }
  }
})



option = {
  title: {
    text: "",
    x: 'center',
    y: 10,
    padding: 1,             // 标题内边距，单位px，默认各方向内边距为5，
    itemGap: 0,             // 主副标题纵向间隔，单位px，默认为10，
    textStyle: {
      fontSize: 13,
      color: '#333'                             // 主标题文字颜色
    },
  },
  grid: {
    y: 30
  },
  backgroundColor: 'rgba(255,255,255,1)',
  yAxis: {
    type: 'value'
  },
  xAxis: {
    type: 'category',
    data: []
  },
  series: {
    data: [],
    type: 'line',
    smooth: true
  }

};

function getproduct(pageNum, PAGE_SIZE, keyword, mallFilter) {
  // keyword保留
  vm4.keyword = keyword;
  $.ajax({
    url: "http://localhost:8201/search",
    type: "post",
    contentType: "application/json;charset=UTF-8",
    dataType: "json",
    data: JSON.stringify({
      key: keyword,
      pageNum: pageNum,
      pageSize: PAGE_SIZE,
      mallFilter: mallFilter
    })
  }).success(function (res) {
    vm.total = res.total;
    console.log(vm.total == 0);
    console.log(vm.total != 0);
    vm.productContent = res.products;
    vm1.productNum = res.total;
    vm3.current = pageNum;
    vm3.allpage = res.totalPage; //todo
    if (vm3.allpage > 10) {
      vm3.showItem = 10;
    } else if (vm3.allpage == 0) {
      vm3.showItem = 0;
    } else {
      vm3.showItem = res.totalPage;
    }
    //刷新分页组件
    vm3.reload();
  })
}

function getEchartData(productId, myChart) {
  $.ajax({
    url: "http://localhost:8201/historyPrice",
    type: "post",
    contentType: "application/json;charset=UTF-8",
    dataType: "json",
    data: JSON.stringify({
      productId: productId
    })
  }).success(function (res) {
    console.log(res)
    option:{
    }

    myChart.setOption({
      xAxis: {
        data: res.dateListString
      },
      series: {
        data: res.priceList
      },
      title: {
        text: "历史最低价:" + res.lowestPrice
      }
    })
  })
}

//分页组件
Vue.component("page", {
  template: "#page",
  data: function () {
    return {
      current: vm3.current,
      showItem: vm3.showItem,
      allpage: vm3.allpage
    };
  },
  computed: {
    pages: function () {
      var pag = [];
      if (this.current < this.showItem) {
        //如果当前的激活的项 小于要显示的条数
        //总页数和要显示的条数那个大就显示多少条
        var i = Math.min(this.showItem, this.allpage);
        while (i) {
          pag.unshift(i--);
        }
      } else {
        //当前页数大于显示页数了
        var middle = this.current - Math.floor(this.showItem / 2), //从哪里开始
          i = this.showItem;
        if (middle > this.allpage - this.showItem) {
          middle = this.allpage - this.showItem + 1;
        }
        while (i--) {
          pag.push(middle++);
        }
      }
      return pag;
    }
  },
  methods: {
    goto: function (index) {
      if (index == this.current) return;
      this.current = index;
      var keyword = vm4.keyword;
      getproduct(index - 1, PAGE_SIZE, keyword);
    }
  }
});