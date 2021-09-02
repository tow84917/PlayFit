package com.java016.playfit.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.svg2svg.SVGTranscoder;
import org.springframework.stereotype.Component;



@Component
public class CreateAvatar {

	//Output as SVG
		public void outputSvg(TranscoderInput input, File outFile) 
		     throws IOException, TranscoderException {
		     SVGTranscoder t = new SVGTranscoder();
		     try (OutputStream os = new FileOutputStream(outFile)) {
		       OutputStreamWriter writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
		       TranscoderOutput output = new TranscoderOutput(writer);
		       t.transcode(input, output);
		     }
		   }

}
