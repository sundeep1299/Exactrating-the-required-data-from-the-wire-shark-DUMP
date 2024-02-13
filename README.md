# RTPSplitter

RTPSplitter is a Java tool for parsing and splitting Real-Time Protocol (RTP) and Session Initiation Protocol (SIP) packets from a Packet Capture (PCAP) file. This tool allows you to analyze VoIP (Voice over Internet Protocol) traffic by extracting and grouping SIP flows and RTP streams from network packet captures.

## Features

- Parses SIP and RTP packets from PCAP files.
- Groups SIP packets into call sessions based on the Call-ID header.
- Groups RTP packets into media streams based on the source IP address and port.
- Saves grouped SIP flows and RTP streams into separate PCAP files.
- Provides flexibility for further analysis or processing of VoIP traffic data.

## Usage

1. Clone this repository to your local machine:


git clone https://github.com/yourusername/RTPSplitter.git

cd RTPSplitter
javac -cp .:lib/* io/pkts/tools/RTPSplitter.java

java -cp .:lib/* io.pkts.tools.RTPSplitter
```bash
Dependencies
RTPSplitter uses the following dependencies:

pkts.io: A Java library for working with network packet captures.
pkts-io-pkts-2.0.1.jar: The pkts.io library JAR file.

Contributing
Contributions are welcome! Feel free to open issues or pull requests for any bugs or enhancements you'd like to see.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.


Make sure to replace the placeholders (e.g., `yourusername`) with your actual GitHub username and adjust any paths or instructions as needed. Additionally, if you have any specific setup instructions or additional details about the tool, feel free to add them to the README.md file.
