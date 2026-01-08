(function (factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin-kotlin-stdlib.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin-kotlin-stdlib.js'));
  else {
    if (typeof globalThis['kotlin-kotlin-stdlib'] === 'undefined') {
      throw new Error("Error loading module 'kmp:shared-logic'. Its dependency 'kotlin-kotlin-stdlib' was not found. Please, check whether 'kotlin-kotlin-stdlib' is loaded prior to 'kmp:shared-logic'.");
    }
    globalThis['kmp:shared-logic'] = factory(typeof globalThis['kmp:shared-logic'] === 'undefined' ? {} : globalThis['kmp:shared-logic'], globalThis['kotlin-kotlin-stdlib']);
  }
}(function (_, kotlin_kotlin) {
  'use strict';
  //region block: imports
  var protoOf = kotlin_kotlin.$_$.d;
  var initMetadataForObject = kotlin_kotlin.$_$.c;
  var defineProp = kotlin_kotlin.$_$.b;
  var VOID = kotlin_kotlin.$_$.a;
  //endregion
  //region block: pre-declaration
  initMetadataForObject(SharedApi, 'SharedApi');
  //endregion
  function SharedApi() {
  }
  protoOf(SharedApi).add = function (a, b) {
    return a + b | 0;
  };
  protoOf(SharedApi).subtract = function (a, b) {
    return a - b | 0;
  };
  var SharedApi_instance;
  function SharedApi_getInstance() {
    return SharedApi_instance;
  }
  //region block: init
  SharedApi_instance = new SharedApi();
  //endregion
  //region block: exports
  function $jsExportAll$(_) {
    var $com = _.com || (_.com = {});
    var $com$mikewilcome = $com.mikewilcome || ($com.mikewilcome = {});
    var $com$mikewilcome$kmp = $com$mikewilcome.kmp || ($com$mikewilcome.kmp = {});
    defineProp($com$mikewilcome$kmp, 'SharedApi', SharedApi_getInstance, VOID, true);
  }
  $jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=kmp-shared-logic.js.map
