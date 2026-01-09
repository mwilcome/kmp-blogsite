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
  var protoOf = kotlin_kotlin.$_$.f;
  var initMetadataForObject = kotlin_kotlin.$_$.e;
  var defineProp = kotlin_kotlin.$_$.b;
  var VOID = kotlin_kotlin.$_$.a;
  var initMetadataForClass = kotlin_kotlin.$_$.c;
  var initMetadataForCompanion = kotlin_kotlin.$_$.d;
  //endregion
  //region block: pre-declaration
  initMetadataForObject(SharedApi, 'SharedApi');
  initMetadataForObject(ContentCatalog, 'ContentCatalog');
  initMetadataForClass(ContentDocument, 'ContentDocument');
  initMetadataForCompanion(Companion);
  initMetadataForClass(ContentBlock, 'ContentBlock');
  //endregion
  function SharedApi() {
  }
  protoOf(SharedApi).add = function (a, b) {
    return a + b | 0;
  };
  protoOf(SharedApi).subtract = function (a, b) {
    return a - b | 0;
  };
  protoOf(SharedApi).getDocument = function (id) {
    return ContentCatalog_getInstance().c(id);
  };
  var SharedApi_instance;
  function SharedApi_getInstance() {
    return SharedApi_instance;
  }
  function ContentCatalog() {
    ContentCatalog_instance = this;
    var tmp = this;
    // Inline function 'kotlin.arrayOf' call
    // Inline function 'kotlin.js.unsafeCast' call
    // Inline function 'kotlin.js.asDynamic' call
    var tmp$ret$2 = [Companion_instance.paragraph('This project shares core logic in Kotlin Multiplatform.'), Companion_instance.paragraph('Android renders UI with Compose. The web client will render UI with Angular.'), Companion_instance.paragraph('Some content is easier to maintain in one place. This screen is an example: the same text is provided by shared-logic.'), Companion_instance.paragraph('The goal here is consistency and reuse, not legal wording.'), Companion_instance.paragraph('Select Continue to enter the app.')];
    tmp.a_1 = new ContentDocument(1, 'welcome', 'Welcome', 'Last updated: 2026-01-09', tmp$ret$2);
    var tmp_0 = this;
    var tmp_1 = Companion_instance.paragraph('Use this project like a playground: read the notes, then try the interactive pieces.');
    var tmp_2 = Companion_instance;
    // Inline function 'kotlin.arrayOf' call
    // Inline function 'kotlin.js.unsafeCast' call
    // Inline function 'kotlin.js.asDynamic' call
    var tmp$ret$5 = ['Open Labs and pick a topic.', 'Read the description first.', 'Use the controls and observe how state changes.', 'Return to the hub and repeat.'];
    // Inline function 'kotlin.arrayOf' call
    // Inline function 'kotlin.js.unsafeCast' call
    // Inline function 'kotlin.js.asDynamic' call
    var tmp$ret$8 = [tmp_1, tmp_2.numberedList(tmp$ret$5)];
    tmp_0.b_1 = new ContentDocument(1, 'quick_start', 'Quick Start', null, tmp$ret$8);
  }
  protoOf(ContentCatalog).c = function (id) {
    switch (id) {
      case 'welcome':
        return this.a_1;
      case 'quick_start':
        return this.b_1;
      default:
        return null;
    }
  };
  var ContentCatalog_instance;
  function ContentCatalog_getInstance() {
    if (ContentCatalog_instance == null)
      new ContentCatalog();
    return ContentCatalog_instance;
  }
  function ContentDocument(schemaVersion, id, title, meta, blocks) {
    this.schemaVersion = schemaVersion;
    this.id = id;
    this.title = title;
    this.meta = meta;
    this.blocks = blocks;
  }
  protoOf(ContentDocument).d = function () {
    return this.schemaVersion;
  };
  protoOf(ContentDocument).e = function () {
    return this.id;
  };
  protoOf(ContentDocument).f = function () {
    return this.title;
  };
  protoOf(ContentDocument).g = function () {
    return this.meta;
  };
  protoOf(ContentDocument).h = function () {
    return this.blocks;
  };
  function Companion() {
  }
  protoOf(Companion).i = function (text, level) {
    return new ContentBlock('heading', text, level, null);
  };
  protoOf(Companion).heading = function (text, level, $super) {
    level = level === VOID ? 2 : level;
    return $super === VOID ? this.i(text, level) : $super.i.call(this, text, level);
  };
  protoOf(Companion).paragraph = function (text) {
    return new ContentBlock('paragraph', text, null, null);
  };
  protoOf(Companion).numberedList = function (items) {
    return new ContentBlock('numbered_list', null, null, items);
  };
  var Companion_instance;
  function Companion_getInstance() {
    return Companion_instance;
  }
  function ContentBlock(type, text, level, items) {
    this.type = type;
    this.text = text;
    this.level = level;
    this.items = items;
  }
  protoOf(ContentBlock).j = function () {
    return this.type;
  };
  protoOf(ContentBlock).k = function () {
    return this.text;
  };
  protoOf(ContentBlock).l = function () {
    return this.level;
  };
  protoOf(ContentBlock).m = function () {
    return this.items;
  };
  //region block: init
  SharedApi_instance = new SharedApi();
  Companion_instance = new Companion();
  //endregion
  //region block: exports
  function $jsExportAll$(_) {
    var $com = _.com || (_.com = {});
    var $com$mikewilcome = $com.mikewilcome || ($com.mikewilcome = {});
    var $com$mikewilcome$kmp = $com$mikewilcome.kmp || ($com$mikewilcome.kmp = {});
    defineProp($com$mikewilcome$kmp, 'SharedApi', SharedApi_getInstance, VOID, true);
    var $com = _.com || (_.com = {});
    var $com$mikewilcome = $com.mikewilcome || ($com.mikewilcome = {});
    var $com$mikewilcome$kmp = $com$mikewilcome.kmp || ($com$mikewilcome.kmp = {});
    var $com$mikewilcome$kmp$content = $com$mikewilcome$kmp.content || ($com$mikewilcome$kmp.content = {});
    $com$mikewilcome$kmp$content.ContentDocument = ContentDocument;
    $com$mikewilcome$kmp$content.ContentBlock = ContentBlock;
    defineProp($com$mikewilcome$kmp$content.ContentBlock, 'Companion', Companion_getInstance, VOID, true);
  }
  $jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=kmp-shared-logic.js.map
