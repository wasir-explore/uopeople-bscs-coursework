# Smart Campus Networking: Topologies, PAN/WAN/MAN Integration, and the Protocols Behind It

A Smart Campus like the one in this scenario needs to enhance network efficiency, support campus mobility, and enable collaborative learning across a growing number of students, faculty, and connected devices, and all three goals trace back to choices made in the network's physical layout and its protocols.

Topology shapes efficiency and reliability by determining how many paths exist between devices and what happens when one fails. A star topology scales easily as the university adds devices to its central switch, but that hub is a single point of failure for the whole segment (Make It Easy Education, 2021). Bus topologies share that fault-tolerance problem, and performance degrades as more devices compete for one shared cable. A ring loses all traffic to one broken link without a backup ring. Mesh solves this with multiple routes to each destination, the redundancy Dordal (2023, Section 1.5) describes: a loop-free network has none, so one break partitions it, while redundant links need a protocol to pick a path and reroute on failure. A growing Smart Campus fits a hybrid design: star-wired buildings for scalability, with a redundant mesh backbone for fault tolerance without sacrificing performance.

PANs, WANs, and MANs cover different ranges, and a Smart Campus needs all three to support traffic monitoring, intelligent transportation, and public Wi-Fi. A PAN connects a student's own devices, like a phone paired to a smartwatch over Bluetooth (Code-exe, 2020). A MAN links campus buildings into the city's metropolitan infrastructure, including the traffic center that pulls real-time data from roadside sensors to adjust signal timing and catch incidents faster than a human operator (IEEE Technology Navigator, n.d.). A WAN then carries that data, along with general internet traffic, out to the wider internet. Chained together, a student's phone pulls live bus times from MAN-based sensors, campus Wi-Fi stays available between buildings, and nearby intersections grow safer and less congested, making campus and city life noticeably smoother.

Ethernet, IP, and TCP map onto different layers of the four-layer Internet model, which OSI's seven-layer model splits further (Dordal, 2023, Section 1.15). Ethernet sits at the Link layer, matching OSI's Physical and Data Link layers, delivering frames inside each building's network. IP sits at the Internetwork layer, matching OSI's Network layer, routing packets to the internet. TCP, at the Transport layer, guarantees lossless delivery, which matters most for file sharing and HTTP-based browsing (CertBros, 2020). Video conferencing is the exception: a frozen frame is worse than a degraded one, so that traffic rides UDP instead, trading reliability for lower latency, while HTTP and the Application layer, absorbing OSI's Session and Presentation layers, matter most for setting up the call.

Question for the class: since TCP trades speed for reliability and UDP trades reliability for speed, how would you design a campus network to keep both file transfers and live video classes running well on the same infrastructure?

## References

CertBros. (2020, April 21). *TCP/IP model explained | Cisco CCNA 200-301* [Video]. YouTube. https://www.youtube.com/watch?v=OTwp3xtd4dg

Code-exe. (2020, October 10). *Networks - Episode 2 | LAN, WAN & PAN* [Video]. YouTube. https://www.youtube.com/watch?v=IXkMgGhUcgE

Dordal, P. L. (2023). *Introduction to computer networks* (2nd ed.). https://intronetworks.cs.luc.edu/current2/html/index.html

IEEE Technology Navigator. (n.d.). *Intelligent transportation systems*. IEEE. https://technav.ieee.org/area/intelligent-transportation-systems/

Make It Easy Education. (2021, April 7). *Computer networks topology || Mesh, bus, star, ring, and hybrid technology* [Video]. YouTube. https://www.youtube.com/watch?v=mpFWIZ318eQ
