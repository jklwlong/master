;(function($, plupload) {

  var _appId, _bucket, _sign;

  var settings = null;

  var defaults = {

    // can be html5,flash,silverlight,html4
    runtimes : 'flash',

    //url : getServerUrl(),
    //drop_element: "uploader",
    //browse_button: "selectFiles",
    //container: "uploader",
    //flash_swf_url : '../js/Moxie.swf',

    // Needed for the Flash environment to work.
    //urlstream_upload: true,

    file_data_name: 'FileContent',
    multipart: true,
    multipart_params: {
      'Content-Type': 'image/*'
    },

    max_file_size : '10mb'

  };

  function Uploader(appId, bucket, sign, options) {

    settings = $.extend({}, defaults, options);

    _appId = appId;
    _bucket = bucket;
    _sign = sign;

    settings.url = getServerUrl();

    var uploader = new plupload.Uploader(settings);

    // Set up the event handlers for the uploader.
    uploader.bind( "Init", handlePluploadInit );
    uploader.bind( "Error", handlePluploadError );
    uploader.bind( "FilesAdded", handlePluploadFilesAdded );
    uploader.bind( "QueueChanged", handlePluploadQueueChanged );
    uploader.bind( "BeforeUpload", handlePluploadBeforeUpload );
    uploader.bind( "UploadProgress", handlePluploadUploadProgress );
    uploader.bind( "FileUploaded", handlePluploadFileUploaded );
    uploader.bind( "StateChanged", handlePluploadStateChanged );
	uploader.bind( "UploadComplete",handlePluploadUploadComplete);


    var callbacks = getEventCallbacks(uploader);

    // I exports some API of this wrapper for qcloud uploader clients.
    return $.extend({
      init: function() {
        uploader.init();
      }
    }, callbacks);

  } // function Uploader()

  window.QCloudUploader = Uploader;


  // ------------------------------------------------------------
  // ------------------------------------------------------------

  function getContentTypeFromFilename( name ) {
      if ( /\.jpe?g$/i.test( name ) ) {
          return( "image/jpg" );
      } else if ( /\.png/i.test( name ) ) {
          return( "image/png" );
      } else if ( /\.gif/i.test( name ) ) {
          return( "image/gif" );
      }else if ( /\.bmp/i.test( name ) ) {
          return( "image/bmp" );
      }
      // If none of the known image types match, then
      // just use the default octet-stream.
      return( "application/octet-stream" );
  }


  function handlePluploadBeforeUpload( uploader, file ) {
      //console.log( "File upload about to start." );
  }

  function handlePluploadInit( uploader, params ) {
      //console.log( "Initialization complete." );
      //console.info( "Drag-drop supported:", !! uploader.features.dragdrop );
  }

  function handlePluploadError(uploader, error) {
      //console.warn( "Error during upload." );
	  //console.warn(error);
  }

  function handlePluploadFilesAdded( uploader, files ) {
      //console.log( "Files selected." );
      // Make sure we filter OUT any non-image files.
      for ( var i = ( files.length - 1 ) ; i >=0 ; i-- ) {
          if ( ! isImageFile( files[ i ] ) ) {
              //console.warn( "Rejecting non-image file." );
              files.splice( i, 1 );
          }
      }
  }

  function handlePluploadQueueChanged( uploader ) {
      //console.log( "Files added to queue." );
      if ( uploader.files.length && isNotUploading(uploader) ){
          uploader.start();
      }
  }

  function handlePluploadUploadProgress( uploader, file ) {
      // console.info( "Upload progress:", file.percent );
  }

  
  function handlePluploadUploadComplete( uploader, file ) {
      // console.info( "Upload progress:", file.percent );
  }

  function handlePluploadFileUploaded( uploader, file, response ) {
      var resourceData = (JSON.parse(response.response)).data;
  }

  function handlePluploadStateChanged( uploader ) {
      //console.log( "PluploadStateChanged: ", isUploading(uploader) ? "Uploading" : "" );
  }

  // NOTE: Our policy requires us to send image files.
  function isImageFile( file ) {
      var contentType = getContentTypeFromFilename( file.name );
      // Make sure the content type starts with the
      // image super-type.
      return( /^image\//i.test( contentType ) );
  }

  // I determine if the upload is currently inactive.
  function isNotUploading(uploader) {
      var currentState = uploader.state;
      return( currentState === plupload.STOPPED );
  }

  // I determine if the uploader is currently uploading a
  // file (or if it is inactive).
  function isUploading(uploader) {
      var currentState = uploader.state;
      return( currentState === plupload.STARTED );
  }

  function getServerUrl() {
    return "http://web.image.myqcloud.com/photos/v2/" + _appId + "/" + _bucket + "/0/" +
      "?sign=" + encodeURIComponent(_sign);
  }


  // exports event listeners for API:
  // {
  //  onInit: function() { .. }
  //  onError: function() { .. }
  //  onFilesAdded: function() { .. }
  //  onQueueChanged: function() { .. }
  //  onBeforeUpload: function() { .. }
  //  onUploadProgress: function() { .. }
  //  onFileUploaded: function() { .. }
  //  onStateChanged: function() { .. }
  // }
  function getEventCallbacks(uploader) {
    
    // get a wrapper for binding event to remove first argument (uploader) all the time.
    function wrapPlUploadCallback(uploader, cb) {
      return function() {
        var args = [].slice.call(arguments, 1);
        return cb.apply(uploader, args);
      }
    }

    var callbacks = {};

    var events = [ "Init", "Error", "FilesAdded", "QueueChanged", "BeforeUpload",
      "UploadProgress", "FileUploaded", "StateChanged","UploadComplete" ];

    $.each(events, function(i, v) {
      callbacks["on" + v] = function(cb) {
        // bind every supported events for incoming callback
        uploader.bind(v, wrapPlUploadCallback(uploader, cb));
      };
    });

    return callbacks;

  } // getEventCallbacks()

})(jQuery, plupload);

