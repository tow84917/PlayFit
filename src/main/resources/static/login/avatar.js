window.addEventListener('load',doFirst);

const fat = `<path class="st4" d="M296.6,206.3c0-24.5-7-49.3-18.9-72.2c-2.9-5.6-1.8-12.7,2.4-17.1c9-9.3,13.2-19.7,9.9-26.8
c-4.2-9-19.2-9.9-35.6-3c-4.5,1.9-9.5,0.8-13.1-2.7C213.7,57.2,179.1,39,145.3,39C71.6,39.1,4.4,133,3.4,214.3
c-0.8,62.1,49.2,78.1,69.8,89.9c5.7,3.2,11.5,9.6,12.3,16.6c0,0,0,0,0,0.1c2.9,17.6,11.8,30.6,24.7,28.9c10-1.3,17.3-12.8,19.1-27.9
c0.4-3.9,3.5-6.7,7-6.6c2.7,0.1,5.4,0.1,8.2,0.1c6.4,0,12.8-0.2,19.2-0.6c3.5-0.3,6.6,2.7,6.9,6.6c1.6,15.4,9,28.4,19.2,28.6
c9.3,0.2,22.4-16.8,24.1-34.8l0.3-2.4c0.4-4.1,3-7.6,6.6-9C262,288.3,296.6,257.3,296.6,206.3z"/>
<path class="st5" d="M95.2,119c14.5-1.2,26.9,4.8,27.6,13.2c0.7,8.4-10.6,16.3-25.1,17.4L84,150.7"/>
<path class="st6" d="M142.2,69.8c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9
C135.3,69.4,139.3,71.4,142.2,69.8z"/>
<path class="st6" d="M160.9,60.3c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9C154,59.8,158,61.8,160.9,60.3z
"/>
<path class="st5" d="M106.7,58.5c0,0,2.6-26.1,23.5-21.4c4,0.9,7.9-0.3,11-2.9c3.8-3.1,10.2-5.9,19.8-1.9"/>`;

const fat_body1 =   `<path class="st2" d="M31.4,142.7L16.6,156"/>
                <path class="st2" d="M18.2,131.9L3.4,145.2"/>
                <path class="st2" d="M41.2,151.9l-8.7,14.1"/>
                <path class="st2" d="M53.3,155.9l-5.5,16.5"/>
                <path class="st3" d="M60.1,66.7c0,0,99.8,28.1,175.6-1.4c0,0,18.2-1.3,4.2,15c0,0,18.6,3.5,7.4,15.4c-11.2,11.9-62.1,50.6-195.4,7.7
                c0,0-20.3-18.9,0.9-17.1C52.9,86.2,36.7,66.2,60.1,66.7z"/>
                <path class="st3" d="M52,103.3c0,0-31.5,5.7-41.1,27.1c0,0,28.3,28.4,48.1,25.8l24.1-43.7L52,103.3z"/>`;

const fat_body2 =   `<path class="st9" d="M213,110.1l-81.2,5.5l3.2,47.9l81.2-5.5L213,110.1z"/>
<path class="st10" d="M141.7,126.9l-9.1,0.6l1.6,24l9.1-0.6L141.7,126.9z"/>
<path class="st11" d="M216.3,157.7l-81.2,5.5l0.8,11.9l81.2-5.5L216.3,157.7z"/>
<path class="st12" d="M144.2,162.6l-9.1,0.6l0.8,11.9l9.1-0.6L144.2,162.6z"/>
<path class="st11" d="M213,110.1l-81.2,5.5l0.8,11.9l81.2-5.5L213,110.1z"/>
<path class="st13" d="M213.8,122l-9.1,0.6l1.6,24l9.1-0.6L213.8,122z"/>
<path class="st14" d="M216.3,157.7l-9.1,0.6l0.8,11.9l9.1-0.6L216.3,157.7z"/>
<path class="st15" d="M184.2,106c-7.3,0.5-17,1.1-24.3,1.6l-1.9,6.1c8.9-0.6,20-1.3,28.8-1.9L184.2,106z"/>
<path class="st16" d="M149.2,110.2l-10.4,0.7l0.3,4.2l10.4-0.7L149.2,110.2z"/>
<path class="st16" d="M205.6,106.4l-10.4,0.7l0.3,4.2l10.4-0.7L205.6,106.4z"/>
<path class="st17" d="M144.3,110.6l-0.8,0.1l0.3,4.2l0.8-0.1L144.3,110.6z"/>
<path class="st17" d="M140.7,110.8l-0.8,0.1l0.3,4.2l0.8-0.1L140.7,110.8z"/>
<path class="st17" d="M142.5,110.7l-0.8,0.1l0.3,4.2l0.8-0.1L142.5,110.7z"/>
<path class="st17" d="M146.1,110.4l-0.8,0.1l0.3,4.2l0.8-0.1L146.1,110.4z"/>
<path class="st17" d="M147.9,110.3l-0.8,0.1l0.3,4.2l0.8-0.1L147.9,110.3z"/>
<path class="st13" d="M204.8,122.6l-63,4.3l0.1,1.2l62.9-4.2L204.8,122.6L204.8,122.6z"/>
<path class="st18" d="M213.8,122l-9.1,0.6l0.1,1.2l9.1-0.6L213.8,122z"/>
<path class="st9" d="M141.7,126.9l-9.1,0.6l0.1,1.2l9.1-0.6L141.7,126.9z"/>
<path class="st13" d="M206.3,145.5l-63,4.3l0.1,1.2l62.9-4.2L206.3,145.5L206.3,145.5z"/>
<path class="st18" d="M215.4,144.8l-9.1,0.6l0.1,1.2l9.1-0.6L215.4,144.8z"/>
<path class="st9" d="M143.3,149.7l-9.1,0.6l0.1,1.2l9.1-0.6L143.3,149.7z"/>
<path class="st16" d="M175.6,157.3c11.3-0.9,19.8-10.7,18.9-22c-0.9-11.3-10.7-19.8-22-18.9s-19.8,10.7-18.9,22
	C154.5,149.7,164.4,158.1,175.6,157.3z"/>
<path class="st19" d="M190.1,135.7c-0.6-8.8-8.2-15.6-17.1-15c-8.8,0.6-15.6,8.2-15,17.1c0.6,8.8,8.2,15.6,17.1,15
	C184,152.2,190.7,144.5,190.1,135.7z"/>
<path class="st20" d="M167.3,133.6c3.5-4.2,5.9-8.7,7-12.9c-0.4,0-0.8,0-1.3,0c-8.9,0.6-15.6,8.2-15,17.1c0.1,1.1,0.2,2.2,0.5,3.2
	C161.5,139.2,164.6,136.7,167.3,133.6z"/>
<path class="st21" d="M179.3,136.4c-0.2-2.9-2.7-5.1-5.6-4.9s-5.1,2.7-4.9,5.6s2.7,5.1,5.6,4.9C177.3,141.8,179.5,139.3,179.3,136.4
	z"/>
<path class="st22" d="M184.2,106l-7.6,0.5l2.7,5.8l7.5-0.5L184.2,106z"/>
<path class="st23" d="M131.1,121.9l1.1-0.1l-0.1-1.5l-1.9,0.1c-0.6,0-1.1,0.6-1,1.3l0.2,3.5c0,0.6,0.5,1.1,1.2,1.1l1.9-0.1l-0.1-1.5
	l-1.1,0.1c-0.3,0-0.5-0.2-0.5-0.5l-0.1-1.7C130.7,122.2,130.8,121.9,131.1,121.9z"/>
<path class="st24" d="M54.5,87.2c0,0,51.5,30.4,79.2,36.1"/>
<path class="st23" d="M214.8,119.2l-1.1,0.1l0.1,1.5l1.9-0.1c0.6,0,1.1-0.6,1-1.3l-0.2-3.5c0-0.6-0.5-1.1-1.2-1.1l-1.9,0.1l0.1,1.5
	l1.1-0.1c0.3,0,0.5,0.2,0.5,0.5l0.1,1.7C215.3,118.9,215,119.2,214.8,119.2z"/>
<path class="st24" d="M210.9,118.8c0,0,26.6-24.2,26.4-38.9"/>
<path class="st12" d="M140.9,115l-9.1,0.6l0.8,11.9l9.1-0.6L140.9,115z"/>
<path class="st14" d="M213,110.1l-9.1,0.6l0.8,11.9l9.1-0.6L213,110.1z"/>`;


const fat_hat1 = `<path class="st0" d="M85.1,11.4c0,0-5.2-3.7-1.9-7.2c0,0,3-3.3,3-3.7c0,0,2.3-0.4,1.7,2.1c0,0-2.6,5.4-0.4,7.8L85.1,11.4z"/>
<path class="st1" d="M126.9,8C109-1.1,86,8.9,86,8.9s-23.7,8.4-30.5,27.3c0,0-2.6,6.2,2,9.7l10.1,7.2l31-12.2l31-12.2l2.4-12.3
	C133,10.8,126.9,8,126.9,8z"/>`;


const fat_hat2 = `<path class="st7" d="M123.6,20c0,0-2.3-4.5-9.2-2.1c-6.5,6-13.5,10.2-19.9,13.2c-4.1,1.9-8,3.2-11.4,4.2c-5.7,1.6-10.6,2.5-14,2.9
c-2.1,1.5-6.5,5.3-4.7,8.8c0,0,2.6,5.8,14.6,3.3c0,0,18.4-3.7,40-19.9C118.9,30.6,125.8,24.2,123.6,20z"/>
<path class="st8" d="M112.9,15.5l-4.7-8.8c0,0-4.5-7.3-13.4-6.1c0,0-13,2.5-23.1,9.6c0,0-8.3,6.2-5.5,15.1l3.2,10.1
c3.3-0.4,7.8-1.2,12.9-2.7C90.8,30.1,102.6,25.2,112.9,15.5z"/>`;


const thin = `<path class="st4" d="M259,126.7c-3.4-4.6-12.1-4.1-21,0.6c-0.7,0-1.2,0.1-1.2,0.1l-7.6-38.7c0-0.2-0.1-0.3-0.1-0.5
c-10.4-30.2-36.8-50-68.9-49.2c-18.1,0.4-37.1,8.7-47,18.8c-8.3,8.4-23,24.8-30.5,35.1c-4.8-5.3-10.2-7.9-14.3-6.1
c-6.4,2.8-7.2,14.9-1.9,27c0.3,0.8,0.7,1.5,1.1,2.2c1.6,3.1,1.7,6.7,0.4,10c-3.4,8.1-6.6,14.1-9.5,22.3c-3.3,9.4-3.1,9.5-5.8,19.1
c-2.9,10.2-5.4,20.5-7.3,30.9c-1.9,10.3-3.4,20.8-4,31.3c-0.6,9.9-0.4,20,0.9,29.8c1.2,9.1,3.5,18.1,7.4,26.4
c3.7,8,8.8,15.2,15.3,21.1c7.1,6.4,15.7,11,24.8,13.9c3.4,1.1,6.8,1.9,10.3,2.6c1.9,0.4,3.8,0.7,5.6,1c0.1,0,0.2,0,0.3,0.1
c0.1,0.1,0.1,0.2,0.1,0.3c0.6,3.1,1.2,6.3,2.1,9.4c0.9,3,2.1,5.9,3.9,8.5c0,0.1,0.2,0.2,0.2,0.3c2.4,3.2,6.1,5.9,10.3,5
c4.4-0.9,6.2-5.1,7-9.1c0.4-2.1,0.6-4.3,0.8-6.5c0.1-1.5-0.3-5.2,1.5-5.6c0.6-0.1,1.1,0,1.7,0c3.1,0.4,6.1,0.7,9.2,0.9
c2.2,0.1,4.4,0.1,6.7,0.1c1.3,0,2.2,1.4,1.7,2.7c-1.5,3.4-2.6,6.8-2.4,10.6c0.1,3.1,1.2,6.2,4,7.8c5.6,3.2,15.5-3.4,22.1-14.9
c0.5-0.8,0.9-1.6,1.3-2.4c1.1-2.2,3.1-3.8,5.6-4.2c7.4-1.3,15-2.4,21.7-6.2c6.6-3.7,12.6-8.5,17.6-14.1
c9.5-10.5,15.6-23.7,18.4-37.6c7.3-36,3.6-75.5,0.6-111.9c-0.1-1.4,0.6-2.8,1.9-3.5c1.7-0.9,3.5-2.1,5.2-3.3
C257.9,143.2,263.1,132.3,259,126.7z"/>
<path d="M149.2,65.9c1.6-2.5,4.3-3,6.1-1.1c1.8,1.9,1.9,5.5,0.3,8c-1.6,2.5-4.3,3-6.1,1.1S147.6,68.4,149.2,65.9z"/>
<path d="M164,68.2c1.6-2.5,4.3-3,6.1-1.1c1.8,1.9,1.9,5.5,0.3,8c-1.6,2.5-4.3,3-6.1,1.1S162.4,70.7,164,68.2z"/>`;

const thin_body1 = `<path class="st7" d="M66.7,122.4l-13.4,8.5"/>
<path class="st7" d="M57.7,112.1l-13.4,8.5"/>
<path class="st7" d="M73.2,131l-8.7,10"/>
<path class="st7" d="M82.2,135.7L75.7,148"/>
<path class="st3" d="M98.9,66c0,0,70.5,43.4,135.2,37.3c0,0,14.2,3,0,12.5c0,0,13.5,6.7,2.3,13.5c-11.2,6.7-58.8,25.3-151.8-36.8
	c0,0-11.4-18.9,4.5-13C89.2,79.4,81.1,60.5,98.9,66z"/>
<path class="st3" d="M93.5,91.8c0,0-31,2.6-41.3,18.2c0,0,18.5,26.2,34.5,26.7l24.8-31.2L93.5,91.8z"/>`;
const thin_body2 = `<path class="st10" d="M91.4,164.1l68.5,15.3l9-40.4l-68.5-15.3L91.4,164.1z"/>
<path class="st11" d="M154.5,167.5l7.7,1.7l4.5-20.3l-7.7-1.7L154.5,167.5z"/>
<path class="st12" d="M89.2,173.9l68.5,15.3l2.2-10l-68.5-15.3L89.2,173.9z"/>
<path class="st13" d="M150,187.4l7.7,1.7l2.2-10l-7.7-1.7L150,187.4z"/>
<path class="st12" d="M98.1,133.7l68.5,15.3l2.2-10l-68.5-15.3L98.1,133.7z"/>
<path class="st14" d="M93.6,154l7.7,1.7l4.5-20.3l-7.7-1.7L93.6,154z"/>
<path class="st15" d="M89.2,173.9l7.7,1.7l2.2-10l-7.7-1.7L89.2,173.9z"/>
<path class="st16" d="M122.5,128.5c7.5,1.7,16.8,3.8,24.3,5.4l-0.8-5.5c-6.2-1.4-14.3-3.2-20.5-4.6L122.5,128.5z"/>
<path class="st17" d="M154,135.6l8.8,2l0.8-3.5l-8.8-2L154,135.6z"/>
<path class="st17" d="M106.4,125l8.8,2l0.8-3.5l-8.8-2L106.4,125z"/>
<path class="st18" d="M158.1,136.6l0.7,0.2l0.8-3.5l-0.7-0.2L158.1,136.6z"/>
<path class="st18" d="M161.2,137.2l0.7,0.2l0.8-3.5l-0.7-0.2L161.2,137.2z"/>
<path class="st18" d="M159.7,136.9l0.7,0.2l0.8-3.5l-0.7-0.2L159.7,136.9z"/>
<path class="st18" d="M156.6,136.2l0.7,0.2l0.8-3.5l-0.7-0.2L156.6,136.2z"/>
<path class="st18" d="M155.1,135.9l0.7,0.2l0.8-3.5l-0.7-0.2L155.1,135.9z"/>
<path class="st14" d="M105.9,135.4l-0.2,1l53.1,11.8l0.2-1L105.9,135.4L105.9,135.4z"/>
<path class="st19" d="M97.9,134.7l7.7,1.7l0.2-1l-7.7-1.7L97.9,134.7z"/>
<path class="st10" d="M158.8,148.3l7.7,1.7l0.2-1l-7.7-1.7L158.8,148.3z"/>
<path class="st14" d="M101.6,154.7l-0.2,1l53.1,11.8l0.2-1L101.6,154.7L101.6,154.7z"/>
<path class="st19" d="M93.6,154l7.7,1.7l0.2-1l-7.7-1.7L93.6,154z"/>
<path class="st10" d="M154.5,167.5l7.7,1.7l0.2-1l-7.7-1.7L154.5,167.5z"/>
<path class="st17" d="M147.4,155.5c2.2-9.5-3.7-19.1-13.3-21.3c-9.5-2.2-19.1,3.7-21.3,13.3c-2.2,9.5,3.7,19.1,13.3,21.3
	C135.6,171,145.1,165.1,147.4,155.5z"/>
<path class="st20" d="M127.1,165.1c7.5,1.7,14.9-3.1,16.6-10.5c1.7-7.5-3.1-14.9-10.5-16.6c-7.5-1.7-14.9,3.1-16.6,10.5
	C115,155.9,119.6,163.4,127.1,165.1z"/>
<path class="st21" d="M142.9,157.2c0.3-0.8,0.6-1.7,0.8-2.6c1.7-7.5-3-14.9-10.5-16.6c-0.4-0.1-0.8-0.1-1.1-0.2
	c0.4,3.7,1.8,7.9,4.3,11.9C138.3,152.7,140.5,155.2,142.9,157.2z"/>
<path class="st22" d="M129.2,156c2.4,0.5,4.9-1,5.4-3.4c0.5-2.4-1-4.9-3.4-5.4c-2.4-0.5-4.9,1-5.4,3.4
	C125.2,153,126.7,155.3,129.2,156z"/>
<path class="st23" d="M122.6,128.6l6.4,1.4l3-4.6l-6.4-1.4L122.6,128.6z"/>
<path class="st24" d="M168.9,145.1l-0.3,1.5c-0.1,0.2-0.3,0.4-0.5,0.4l-0.9-0.2l-0.3,1.2l1.6,0.4c0.5,0.1,1-0.3,1.1-0.8l0.7-3
	c0.1-0.5-0.2-1.1-0.7-1.2l-1.6-0.4l-0.3,1.3l0.9,0.2C168.9,144.5,169,144.8,168.9,145.1z"/>
<path class="st26" d="M166.3,145.3c24.4-1.2,70.5-17.8,70.5-17.8"/>
<path class="st24" d="M97.5,130.7l0.3-1.5c0.1-0.2,0.3-0.4,0.5-0.4l0.9,0.2l0.3-1.3l-1.6-0.4c-0.5-0.1-1,0.3-1.1,0.8l-0.7,3
	c-0.1,0.5,0.2,1.1,0.7,1.2l1.6,0.4l0.3-1.3l-0.9-0.2C97.5,131.2,97.3,130.9,97.5,130.7z"/>
<path class="st26" d="M83.5,92.4c-2.1,12.5,17.6,39,17.6,39"/>
<path class="st13" d="M159,147.3l7.7,1.7l2.2-10l-7.7-1.7L159,147.3z"/>
<path class="st15" d="M98.1,133.7l7.7,1.7l2.2-10l-7.7-1.7L98.1,133.7z"/>`;
const thin_hat1 = `<path class="st0" d="M185.7,8.5c0,0-2-5,1.9-6c0,0,3.6-1,3.8-1.3c0,0,1.8,0.8,0.3,2.3c0,0-4.3,2.7-3.8,5.4L185.7,8.5z"/>
<path class="st1" d="M217.1,25c-8.7-14.6-29.6-17.9-29.6-17.9s-20.8-4.8-34.2,5.7c0,0-4.7,3.3-3,7.8l4,9.7l27.7,5.4l27.7,5.4
	l7.3-7.7C220.2,29.8,217.1,25,217.1,25z"/>`;
const thin_hat2 = `<path class="st8" d="M228.2,44.2c0,0,1.7-4.7-4.7-7.8c-8.6-0.5-16.3-2.6-22.7-5.2c-4.1-1.6-7.7-3.5-10.7-5.2
c-5-2.9-8.9-5.8-11.5-7.9c-2.5-0.5-8.1-1-9.4,2.6c0,0-2.3,5.8,7.5,12.5c0,0,15,10.5,40.9,14.8C217.6,48,226.8,48.6,228.2,44.2z"/>
<path class="st9" d="M224.2,33.6l3.1-9.2c0,0,2.1-8.1-4.7-13.5c0,0-10.5-7.5-22.3-9.8c0,0-9.9-1.7-14.4,6.3l-5,9
c2.5,2,6.1,4.6,10.6,7.3C199.1,27.9,210.4,32.9,224.2,33.6z"/>`;

function doFirst(){

//角色預覽畫面
avatarPic = document.getElementById('avatarPic');
console.log(avatarPic.innerHTML);


//判斷角色身形
    let avatarSize;
    step3 = document.getElementById('step3');
    let nextStep = document.getElementById('nextStep');
    let weight = document.getElementById('currentWeight');


    nextStep.addEventListener('click',e =>{
        step3.style.display="inline";
        console.log(weight.value);
        if(weight.value>70){
            plainAvatar.innerHTML= fat;      
            body.innerHTML = ``;
            hat.innerHTML = ``;
            avatarSize = 2;  
    
        }else{
            plainAvatar.innerHTML= thin;
            body.innerHTML = ``;
            hat.innerHTML = ``;
            avatarSize = 1;  
        }

    })






//角色的三個部位
plainAvatar = document.getElementById('plainAvatar');
body = document.getElementById('body');
hat = document.getElementById('hat');

//radio選擇項
chooseBodyWhite = document.getElementById("tab1-1");
chooseBody1 = document.getElementById("tab1-2");
chooseBody2 = document.getElementById("tab1-3");
chooseHatWhite = document.getElementById("tab2-1");
chooseHat1 = document.getElementById("tab2-2");
chooseHat2 = document.getElementById("tab2-3");



chooseBody1.addEventListener('click',e => {  
    if(avatarSize == 1){
        body.innerHTML = thin_body1;
    }else if(avatarSize == 2){
        body.innerHTML = fat_body1;
    }
    console.log(avatarPic.innerHTML);
});

chooseBody2.addEventListener('click',e => {  
    if(avatarSize == 1){
        body.innerHTML = thin_body2;
    }else if(avatarSize == 2){
        body.innerHTML = fat_body2;
    }
    // console.log(avatarPic.innerHTML);

});

chooseBodyWhite.addEventListener('click',e => {  
    body.innerHTML = ``;
    // console.log(avatarPic.innerHTML);

});

chooseHat1.addEventListener('click',e => {  
    if(avatarSize == 1){
        hat.innerHTML = thin_hat1;
    }else if(avatarSize == 2){
        hat.innerHTML = fat_hat1;
    }
    // console.log(avatarPic.innerHTML);
});

chooseHat2.addEventListener('click',e => {  
    if(avatarSize == 1){
        hat.innerHTML = thin_hat2;
    }else if(avatarSize == 2){
        hat.innerHTML = fat_hat2;
    }
    // console.log(avatarPic.innerHTML);
});

chooseHatWhite.addEventListener('click',e => {  
    hat.innerHTML = ``;
    // console.log(avatarPic.innerHTML);
});


// 403 錯誤
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
// 403 錯誤


let doneBtn = document.getElementById('doneBtn');

doneBtn.addEventListener('click', e => {
    
    let data = getPictureData();
    
    // let DOMURL = window.URL || window.webkitURL || window;
    
    let svg = new Blob([data],{type: 'image/svg+xml;charset=utf-8'});
    
    // let url = DOMURL.createObjectURL(svg);
    // console.log(svg);
    
    fetch('/process_avatar', {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json',
            "Accept": "application/json",
            "X-Requested-With": "XMLHttpRequest",
        	"X-CSRF-Token": token
        },
        credentials: "same-origin",
        body :data,
    })
    .then(response => {
       console.log(response); 
       return response.json();
    })
    .then(data =>{ 
    	console.log(data);
    })
    
});




//下載

// let downloadBtn = document.querySelector(".downloadBtn");
// downloadBtn.addEventListener("click", downloadFile);

// function downloadFile() {
//   let fileName = "fileName.svg";
//   const data = getPictureData();

//   let link = document.createElement("a");
//   link.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(data));
//   link.setAttribute('download', fileName);
//   link.style.display = 'none';
//   document.body.appendChild(link);

//   link.click();

//   document.body.removeChild(link);
// }
}





    // const xhr = new XMLHttpRequest();

    // // 進度監聽
    // xhr.upload.addEventListener('progress', (e)=>{
    //     console.log(e, e.loaded , e.total); // 可以利用這兩個對象算出目前的傳輸比例
    // }, false);

    // xhr.onreadystatechange = function () {
    //     if (xhr.readyState === 4) {
    //         const result = JSON.parse(xhr.responseText);
    //         if (xhr.status === 200) {
    //             // 上傳成功
    //             console.log(result);
    //         } else {
    //             // 上傳失敗
    //         }
    //     }
    // };
    // xhr.open('POST', '/upload' , true); // 中間"/upload"為後臺上傳地址(如果需要兼容性強可以使用限制的ajax庫)
    // xhr.send(formData); // 發送到後臺


//資料
function getPictureData() {
    let header = `<?xml version="1.0" encoding="utf-8"?>
                  <svg version="1.1" id="avatarPic" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" 
                  viewBox="0 0 300 350" xml:space="preserve">`;
    let style = `<style type="text/css">
  .st0{fill:#A52224;}
  .st1{fill:#D93030;}
  .st2{fill:none;stroke:#040000;stroke-width:5.3533;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
  .st3{fill:#E83C3C;}
  .st4{fill:#F08E93;}
  .st5{fill:none;stroke:#040000;stroke-width:4.6992;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
  .st6{fill:#040000;}
  .st7{fill:#DB9451;}
  .st8{fill:#F4B55E;}
  .st9{fill:#EC6519;}
  .st10{fill:#EF7C33;}
  .st11{fill:#CCCCCC;}
  .st12{fill:#E6E6E5;}
  .st13{fill:#B75320;}
  .st14{fill:#B3B3B3;}
  .st15{fill-rule:evenodd;clip-rule:evenodd;fill:#4D4D4D;}
  .st16{fill:#4D4D4D;}
  .st17{fill:#323333;}
  .st18{fill:#9C4623;}
  .st19{fill-rule:evenodd;clip-rule:evenodd;fill:#CBE8F0;}
  .st20{fill-rule:evenodd;clip-rule:evenodd;fill:#E1F0F3;}
  .st21{fill-rule:evenodd;clip-rule:evenodd;fill:#9ECCD5;}
  .st22{fill-rule:evenodd;clip-rule:evenodd;fill:#323333;}
  .st23{fill-rule:evenodd;clip-rule:evenodd;fill:#666666;}
  .st24{fill:none;stroke:#F4B55E;stroke-width:2.378;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
                 </style>`;
    let data = avatarPic.innerHTML;
  
    return header + style + data + `</svg>`;
  }



